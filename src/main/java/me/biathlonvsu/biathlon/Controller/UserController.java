package me.biathlonvsu.biathlon.Controller;

import lombok.RequiredArgsConstructor;
import me.biathlonvsu.biathlon.Entity.Competition;
import me.biathlonvsu.biathlon.Entity.User;
import me.biathlonvsu.biathlon.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @CrossOrigin()//для фронта в идеи
    @PostMapping("/register")// Регистрация
    public ResponseEntity<User> register(@RequestBody User user){
        return ResponseEntity.ok(userService.register(user.getLogin(), user.getPassword(), user.getName()));
    }

    @CrossOrigin()//для фронта в идеи
    @PostMapping("/login")
    public ResponseEntity<User> logIn(@RequestBody User user){
        return ResponseEntity.ok(userService.logIn(user.getLogin(), user.getPassword()));
    }

    @CrossOrigin()//для фронта в идеи
    @PostMapping("/changePassword")
    public ResponseEntity<Boolean> changeUserPassword(@RequestParam int userId, @RequestParam int newPassword){
        return ResponseEntity.ok(userService.changePassword(userId, newPassword));
    }

    @CrossOrigin()//для фронта в идеи
    @PostMapping("/subscribeToBiathlete")
    public ResponseEntity<Boolean> subscribeToBiathlete(@RequestParam int userId,@RequestParam int biathleteId){
        return ResponseEntity.ok(userService.subscribeToBiathlete(userId, biathleteId));
    }

    @CrossOrigin()//для фронта в идеи
    @PostMapping("/subscribeToCompetition")
    public ResponseEntity<Boolean> subscribeToCompetition(@RequestParam int userId,@RequestParam int competitionId){
        return ResponseEntity.ok(userService.subscribeToCompetition(userId, competitionId));
    }

    @CrossOrigin()//для фронта в идеи
    @PostMapping("/unsubscribeFromBiathlete")
    public ResponseEntity<Boolean> unsubscribeFromBiathlete(@RequestParam int userId,@RequestParam int biathleteId){
        return ResponseEntity.ok(userService.unsubscribeFromBiathlete(userId, biathleteId));
    }

    @CrossOrigin()//для фронта в идеи
    @PostMapping("/unsubscribeFromCompetition")
    public ResponseEntity<Boolean> unsubscribeFromCompetition(@RequestParam int userId,@RequestParam int competitionId){
        return ResponseEntity.ok(userService.unsubscribeFromCompetition(userId, competitionId));
    }

    @CrossOrigin()//для фронта в идеи
    @GetMapping("/allSubscribeCompetitions")
    public ResponseEntity<Set<Competition>> getAllSubscribeCompetition(@RequestParam int userId){
        return ResponseEntity.ok(userService.getAllSubscribeCompetitions(userId));
    }//соревнования на которые подписался юзер

    @CrossOrigin()//для фронта в идеи
    @GetMapping("/allSubscribeCompetitionsWithBiathletes")
    public ResponseEntity<Set<Competition>> getAllCompetitionsSubscribeWithBiathletes(@RequestParam int userId){
        return ResponseEntity.ok(userService.getAllCompetitionsSubscribeWithBiathletes(userId));
    }//соревнования в которых учавствует биатлонисты, на которых подписался юзер

}