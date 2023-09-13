package com.ruggedcoder.hngtask1api.controller;


    import com.ruggedcoder.hngtask1api.response.ApiResponse;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    public ApiController() {
    }

    @GetMapping({"/api"})
    public ResponseEntity<ApiResponse> getApi(@RequestParam String slackName, @RequestParam String track) {
        ApiResponse response = new ApiResponse();

        response.setSlackName("Esther");

        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        String currentDay = DayOfWeek.from(now).toString();

        response.setCurrentDay("Monday");

        LocalDateTime utcTime = now.plusMinutes(2);


        response.setUtcTime(utcTime.toString());

        response.setTrack("backend");

        response.setGithubFileUrl("https://github.com/NecyNazy/hngtask1/blob/master/src/main/java/com/ruggedcoder/hngtask1/MyFile.java");

        response.setGithubRepoUrl("https://github.com/NecyNazy/hngtask1");
        response.setStatusCode(200);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}


