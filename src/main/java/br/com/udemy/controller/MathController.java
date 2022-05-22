package br.com.udemy.controller;

import br.com.udemy.converters.NumberConverter;
import br.com.udemy.exception.UnsuportedMathOperationException;
import br.com.udemy.math.SimpleMath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    public static final String PLEASE_SET_A_NUMERIC_VALUE = "Please set a numeric value!";
    private SimpleMath simpleMath;

    public MathController(SimpleMath simpleMath) {
        this.simpleMath = simpleMath;
    }

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException(PLEASE_SET_A_NUMERIC_VALUE);
        }
        return simpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException(PLEASE_SET_A_NUMERIC_VALUE);
        }
        return simpleMath.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/mult/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable String numberOne, @PathVariable String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException(PLEASE_SET_A_NUMERIC_VALUE);
        }
        return simpleMath.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne, @PathVariable String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException(PLEASE_SET_A_NUMERIC_VALUE);
        }
        return simpleMath.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable String numberOne, @PathVariable String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException(PLEASE_SET_A_NUMERIC_VALUE);
        }
        return simpleMath.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/square/{square}")
    public Double squareRoot(@PathVariable String square) {
        if (!NumberConverter.isNumeric(square)) {
            throw new UnsuportedMathOperationException(PLEASE_SET_A_NUMERIC_VALUE);
        }
        return simpleMath.squareRoot(NumberConverter.convertToDouble(square));
    }
}
