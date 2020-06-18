# Routes    
A tiny Android library for testable navigation logic.
    
## Intro   
Navigating to different screens on Android is handled by starting an [Intent](https://developer.android.com/reference/android/content/Intent), but the Intent class can't be used in unit tests because it depends on Android's [Context](https://developer.android.com/reference/android/content/Context), which is only available at runtime. This makes it difficult to write test scenarios that can check our app is navigating to the right place with the right parameters.  
  
A [Route](https://github.com/greghynds/routes/blob/master/lib/src/main/java/com/gwh/routes/Route.kt) is a simple abstraction of Android's Intent class, but without any dependencies on the Android framework types.* Routes can be created with a set of parameters, just like a Bundle. Using Routes in presentation code makes it easy to unit test our navigation logic. The library also includes some extension methods for using Routes in an Activity class.

\*Except for [Parcelable](https://developer.android.com/reference/android/os/Parcelable). 
  
## Launching a Route from an Activity
```kotlin 
class ExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // create a route with parameters
        val route = Route.to(DestinationActivity::class.java)
            .param("foo", 123)
            .param("bar", true)
            .create()

        // then launch the route directly 
        startActivity(route)

        // or convert to an Intent 
        val intent = intentFor(route)
    }
}
```    
## Receiving parameters in an Activity
```kotlin
class DestinationActivity : AppCompatActivity() {  
  
  override fun onCreate(savedInstanceState: Bundle?) {  
      super.onCreate(savedInstanceState)  
  
	  // access params directly from the Intent  
	  val foo = intent?.extras?.getInt("foo")  
	  val bar = intent?.extras?.getBoolean("bar")  
  
	  // or use the withParams() extension  
	  withParams {  
	      val foo = getInt("foo") 
	      val bar = getBoolean("bar")  
	  }  
     }
 }  
```  

## Testing navigation logic


This is an example of a top-level 'route builder' function that returns a Route with two parameters.  
  
```kotlin  
fun createGreetingRoute(greeting: String, name: String): Route {
    return Route.to(GreetingActivity::class.java)
        .param("key_greeting", greeting)
        .param("key_name", name)
        .create()
}
```  
And here's a test that checks the route is created with the correct destination and parameters.  

```kotlin
@Test 
fun `creates route for greeting page`() {    
    val result = createGreetingRoute("hello", "world")    
    
    // check the destination class
    assert(result.destination == GreetingActivity::class.java)    
    
    // check parameters individually    
    assert(result.params.getString("key_greeting") == "hello")    
    assert(result.params.getString("key_name") == "world")    
    
    // or check against a params object    
    val expected = Route.params()    
        .put("key_greeting", "hello")    
        .put("key_name", "world")    
        .create()    
    
     assert(result.params == expected) 
}  
``` 

## Sample 
You can find a more complete example of using Routes and testing them in the sample project. 


## Installing 

Routes is available on [JitPack](https://jitpack.io). To include it in your project, add the following line to your `build.gradle`:

```gradle
dependencies {
    implementation 'com.github.greghynds:routes:1.0.0'
}
```
  
## Building    
 The project can be built by navigating to the root directory and running:    
    
```./gradlew clean build ```    

## Contributing  
 Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.    

## License
Apache License 2.0
