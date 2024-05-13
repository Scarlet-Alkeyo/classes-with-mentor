fun main() {
    var farmer = Farmer("Ann",30)
    farmer.cultivate()
    farmer.talk()

    var banker = Banker("Alice",35)
   println( banker.calculate(500.0,20.0))
    banker.talk()



//q1
    val fabricPattern = FabricPattern("Ankara Vibrant", "Bright Colors", listOf("Stripes", "Dots"))
    val mood = Mood( "Happy")
    val temperature = Temperature(25.0, "Celsius")

    val predictor = Predictor(fabricPattern, mood, temperature)
    val prediction = predictor.predictDesignChange()

    println(prediction)



//    q7
    val employee = Employee("John Doe", 30, "Manager", 50000.0)
    val bonus = employee.calculateBonus()
    println("Annual Bonus: $bonus")




    val jewelry = Jewelry()


    jewelry.addMoodData("happy")
    jewelry.addTemperatureReading(37.0)
    jewelry.addMoodData("sad")
    jewelry.addTemperatureReading(35.0)

    val predictedTransformation = jewelry.predictTransformation()
    println("Predicted Transformation: $predictedTransformation")

}
   open class  Person( name:String, age:Int){
    fun sleep(){
        println("I am sleeping")
    }

   open fun talk(){
        println("Hello")
    }
}
class Farmer( name:String, age:Int):Person(name,age){
   fun cultivate(){
       println("I am cultivating")
   }
}

class Banker(name:String,age:Int):Person(name,age){
    fun calculate(price:Double,discount:Double):Double{
        var finalPrice=  price -(price* discount/100)
        return finalPrice
    }
    override fun talk(){
        println("I am counting money")

     }
}









class FabricPattern( var patternName: String,var colorScheme: String, var designElements: List<String>) {

    fun displayPattern() {
        println("Displaying $patternName with $colorScheme and $designElements")
    }

}

class Mood(var moodType: String){

    fun impactOnDesign(): String {
        return "Mood $moodType  affects the design"
    }
}



class Temperature(var temperatureValue: Double, var temperatureUnit: String){
    fun impactOnDesign(): String {
        return "Temperature $temperatureValue $temperatureUnit affects the design."
    }
}

class Predictor(fabricPattern: FabricPattern, mood: Mood, temperature: Temperature) {
    private var fabricPattern: FabricPattern = fabricPattern
    private var mood: Mood = mood
    private var temperature: Temperature = temperature

    fun predictDesignChange(): String {
        val moodImpact = mood.impactOnDesign()
        val tempImpact = temperature.impactOnDesign()
        return "Based on $moodImpact and $tempImpact, the predicted design change is: ${fabricPattern.displayPattern()} with modifications."
    }
}

//Create a class called "Employee" with properties for name, age, position, and salary.
//Implement a method that calculates and returns the annual bonus amount for the employee based on
//their position and performance.

class Employee(
    val name: String,
    val age: Int,
    val position: String,
    val salary: Double
) {
    fun calculateBonus(): Double {

        return when (position) {
            "Manager" -> salary * 0.10
            else -> salary * 0.05
        }
    }
}










//You are a designer of mood-changing jewelry that alters its appearance based on the wearer's emotions and body temperature. Create a software system that can predict the changes in
//the jewelry's appearance based on
//the wearer's mood data collected through wearable devices and the body temperature readings.
//Design the classes and methods required to model and predict the jewelry's transformations.

import java.util.*

class MoodData(val mood: String, val timestamp: Date) {
    companion object {
        fun generateMoodData(mood: String): MoodData {
            return MoodData(mood, Date())
        }
    }
}

class BodyTemperatureReading(val temperature: Double, val timestamp: Date) {
    companion object {
        fun generateBodyTemperatureReading(temperature: Double): BodyTemperatureReading {
            return BodyTemperatureReading(temperature, Date())
        }
    }
}

class Jewelry {
    private val moodDataList = mutableListOf<MoodData>()
    private val temperatureReadingsList = mutableListOf<BodyTemperatureReading>()

    fun addMoodData(mood: String) {
        moodDataList.add(MoodData.generateMoodData(mood))
    }

    fun addTemperatureReading(temperature: Double) {
        temperatureReadingsList.add(BodyTemperatureReading.generateBodyTemperatureReading(temperature))
    }

    fun predictTransformation(): String {
        // Simple prediction logic: if mood is happy and temperature is above average, transform to a positive symbol
        val averageTemperature = temperatureReadingsList.averageBy { it.temperature }.toDoubleOrNull()?: 0.0
        val lastMood = moodDataList.lastOrNull()?.mood?: ""
        return if (lastMood == "happy" && averageTemperature > 36.5) {
            "Positive Symbol"
        } else {
            "Neutral Symbol"
        }
    }
}






