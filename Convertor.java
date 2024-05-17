package org.example;

public class Convertor {

    public static String convertTimeToWords(String time) {
        String[] timeArray = time.split(":");
        int hour = Integer.parseInt(timeArray[0]);
        int minute = Integer.parseInt(timeArray[1]);

        String isGoldenHour = checkGoldenHours(hour, minute);

        if(!isGoldenHour.isEmpty()) return isGoldenHour;

        String minuteInWords = convertMinuteToWords(minute);
        String hourInWords =  minuteInWords.contains("to") ? convertHourToWords(hour+1) : convertHourToWords(hour);

        if (minuteInWords.contains("past") || minuteInWords.contains("to")) {
            return minuteInWords + " " + hourInWords;
        }
        return hourInWords + " " + minuteInWords;
    }

    public static String convertHourToWords(int hour) {
        String[] hourWords = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"};
        return hourWords[hour % 12];
    }

    public static String convertMinuteToWords(int minute) {
        String[] minuteWords = {"o'clock", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five", "twenty-six", "twenty-seven",
                "twenty-eight", "twenty-nine", "thirty", "thirty-one", "thirty-two", "thirty-three", "thirty-four", "thirty-five", "thirty-six", "thirty-seven", "thirty-eight", "thirty-nine", "forty", "forty-one", "forty-two", "forty-three", "forty-four", "forty-five", "forty-six", "forty-seven", "forty-eight", "forty-nine", "fifty",
                "fifty-one", "fifty-two", "fifty-three", "fifty-four", "fifty-five", "fifty-six", "fifty-seven", "fifty-eight", "fifty-nine"};

        if(minute % 5 == 0 ) {
                return calculateMinutesResult(minuteWords, minute);
        }
        return minuteWords[minute];
    }

    private static String calculateMinutesResult(String[] minuteWords ,int minute){
        if(minute == 0) return "o'clock";
        if(minute == 15) return "quarter past";
        if(minute == 30) return "half past";
        if(minute == 45) return "quarter to";
        if(minute < 30) return minuteWords[minute] + " past";
        return minuteWords[(60 - minute)] + " to";
    }

    private static String checkGoldenHours(int hour, int minute) {
        if (minute == 0 && hour == 0) {
            return "midnight";
        } else if (minute == 0 && hour == 12) {
            return "noon";
        }
        return "";
    }
}




