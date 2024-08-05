object Converter {
    fun convertLength(value: Double, fromUnit: String?, toUnit: String?): Double {
        var meterValue = 0.0
        when (fromUnit) {
            "Meters" -> meterValue = value
            "Kilometers" -> meterValue = value * 1000
            "Miles" -> meterValue = value * 1609.34
            "Yards" -> meterValue = value * 0.9144
        }
        when (toUnit) {
            "Meters" -> return meterValue
            "Kilometers" -> return meterValue / 1000
            "Miles" -> return meterValue / 1609.34
            "Yards" -> return meterValue / 0.9144
        }
        return 0.0
    }

    fun convertWeight(value: Double, fromUnit: String?, toUnit: String?): Double {
        var gramValue = 0.0
        when (fromUnit) {
            "Grams" -> gramValue = value
            "Kilograms" -> gramValue = value * 1000
            "Pounds" -> gramValue = value * 453.592
            "Ounces" -> gramValue = value * 28.3495
        }
        when (toUnit) {
            "Grams" -> return gramValue
            "Kilograms" -> return gramValue / 1000
            "Pounds" -> return gramValue / 453.592
            "Ounces" -> return gramValue / 28.3495
        }
        return 0.0
    }
}