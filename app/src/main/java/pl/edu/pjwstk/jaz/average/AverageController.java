package pl.edu.pjwstk.jaz.average;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
public class AverageController {

    @GetMapping("average")
    public String getAverage(@RequestParam(value = "numbers", required = false) String numbers){    //required = false -> można nie podać parametru

        if(numbers == null){                                               //jeżeli nie podano parametru
            return "Please put parameters.";
        }
        if(numbers.equals("") || prepareNumbers(numbers).length == 0){     //jeżeli podano pusty string
            return "Please put parameters.";
        }
        else{
            return ("Average equals: " + calculateAverage(prepareNumbers(numbers)));
        }
    }

    //Zamienia String z parametru na tablicę liczb całkowitych
    private int[] prepareNumbers(String numbers){

        String[] wholeNumbers = numbers.split("\\D+");            //tworzy tablicę liczb String, rozdziela, eliminujac znaki inne niż liczby
        int[] preparedNumbers = new int[wholeNumbers.length];           //inicjalizacja tablicy liczb int

        //zmiana każdego stringa na liczbę
        for(int i=0; i<wholeNumbers.length; i++){
            preparedNumbers[i] = Integer.parseInt(wholeNumbers[i]);     //String --> int
        }
        return preparedNumbers;     //int array
    }

    //Oblicza średnią
    private String calculateAverage(int[] preparedNumbers){

        float avg;
        float sum = 0;

        for (int n : preparedNumbers){
            sum = sum + (float)n;
        }
        avg = sum / (float)preparedNumbers.length;

        //zaokrąglenie w górę i ucięcie zer na końcu
        BigDecimal roundedAverage = new BigDecimal(avg);
        roundedAverage = roundedAverage.setScale(2, RoundingMode.HALF_UP).stripTrailingZeros();

        return String.valueOf(roundedAverage);
    }
}