# Routes    
A tiny Android library for testable navigation logic

![CI](https://github.com/greghynds/routes/workflows/CI/badge.svg)
    
## Overview   
- A Route is a simple abstraction of Android's Intent class. 
- Routes can be created with a set of parameters, just like a Bundle. 
- Routes don't depend on the Android framework, so they can be used in unit tests


## Usage
### Create a Route
```kotlin 
// create a route with parameters
val route = Route.to(DestinationActivity::class.java)
    .param("foo", 123)
    .param("bar", true)
    .create()
```

### Launch a Route
```kotlin
// launch the route directly 
startActivity(route)

// or convert to an Intent 
val intent = intentFor(route)
startActivity(intent)
```    

### Receive parameters
```kotlin
// access params directly from the Intent
val foo = intent?.extras?.getInt("foo")
val bar = intent?.extras?.getBoolean("bar")

// or use the withParams() extension
withParams {
    val foo = getInt("foo")
    val bar = getBoolean("bar")
}
```  

## Sample 
You can find an example of using Routes and testing them in the [sample project](https://github.com/greghynds/routes/tree/master/sample/src). 

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
