package pro.sky.mk2homework4calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalcController {

        private final CalcService calcService;


        public CalcController(CalcService calcService) {
                this.calcService = calcService;
        }


        @GetMapping
        public String hello (){
            return "Добро пожаловать в калькулятор!";
        }

        @GetMapping(path= "/plus")
        public String plus (@RequestParam(value = "num1", required = false) Double numA,
                            @RequestParam (value = "num2", required = false) Double numB) {
                if(numA == null || numB == null) {
                        return "Неправильно заданы параметры";
                }
                return numA + " + " + numB + " = " + calcService.plus(numA,numB);
        }

        @GetMapping(path= "/minus")
        public String minus (@RequestParam(value = "num1", required = false) Double numA,
                             @RequestParam (value = "num2",required = false) Double numB) {
                if(Objects.isNull(numA) || Objects.isNull(numB)){
                        return "Неправильно заданы параметры";
                }
                return numA + " - " + numB + " = " + calcService.minus(numA, numB);
        }

        @GetMapping(path= "/multiply")
        public String multiply (@RequestParam(value = "num1", required = false) Double numA,
                                @RequestParam (value = "num2", required = false) Double numB) {
                if( numA == null||numB == null ) {
                        return "Неправильно заданы параметры";
                }
                return numA + " * " + numB + " = " + calcService.multiply(numA, numB);
        }

        @GetMapping( path= "/divide")
        public String divide (@RequestParam(value = "num1",required = false) Double numA,
                              @RequestParam (value = "num2", required = false) Double numB) {
                if(numA == null||numB == null) {
                        return "Неправильно заданы параметры";
                }
                if (numB == 0) {
                     return "Ошибка! На ноль делить нельзя!";

                }
                return numA + " / " + numB + " = " + calcService.divide(numA, numB);
        }
}
