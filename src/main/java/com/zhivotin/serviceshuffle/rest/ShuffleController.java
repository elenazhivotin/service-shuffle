package com.zhivotin.serviceshuffle.rest;

import com.zhivotin.serviceshuffle.service.LogService;
import com.zhivotin.serviceshuffle.service.ShuffleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShuffleController {

    @Autowired
    private ShuffleService shuffleService;

    @Autowired
    private LogService logService;

    /**
     * Get shuffled array
     * @return shuffled array from 1 to @param number without duplications of numbers
     */
    @PostMapping("/array")
    public ResponseEntity<Integer[]> getShuffledArray(@RequestBody Integer number) {
        if(number == null || number < 1 || number > 1000) {
            return ResponseEntity.badRequest().eTag("Input number should be in range 1 - 1000").body(null);
        }
        //send request to service-log
        logService.sendLog(number);

        return ResponseEntity.ok(shuffleService.getShuffledArray(number));
    }
}
