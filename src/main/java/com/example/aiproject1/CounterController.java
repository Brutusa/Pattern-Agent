package com.example.aiproject1;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/counter")
public class CounterController {
    //instantiate the inputs as static
    static String sentenceInput;
    static String patternInput;

    @CrossOrigin
    @PostMapping("/pattern/{pattern}")
    public String enterPattern(@PathVariable String pattern) {
        //prompt user for input
        patternInput = pattern;
        return "Pattern set to " + patternInput;
    }

    //primarily for testing
    @PostMapping("/pattern")
    public String showPattern() {
        //return the pattern
        return "Current pattern is " + patternInput;
    }

    @CrossOrigin
    @PostMapping("/sentence/{sentence}")
    public String enterSentence(@PathVariable String sentence) {
        //enter a string to be searched
        sentenceInput = sentence;
        return "Sentence set to " + sentenceInput;
    }

    //mainly used for testing
    @PostMapping("/sentence")
    public String showSentence() {
        //return the current sentence
        return "Current sentence is " + sentenceInput;
    }

    @CrossOrigin
    @GetMapping("/searchsentence")
    public String searchSentence() {
        //search for the pattern in the string
        if (sentenceInput.contains(patternInput)) {
            return ("I found the pattern '" + patternInput + "' in the sentence '" + sentenceInput + "'");
        } else {
            return ("The pattern '" + patternInput + "' doesn't exist in the sentence '" + sentenceInput + "'");
        }
    }

}
