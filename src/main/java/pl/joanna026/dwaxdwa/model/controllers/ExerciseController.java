package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.joanna026.dwaxdwa.model.entities.Exercise;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.User;
import pl.joanna026.dwaxdwa.model.services.ExerciseCollectionService;
import pl.joanna026.dwaxdwa.model.services.UserService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"results", "size"})
@RequestMapping("/student/exercise")
public class ExerciseController {

    private ExerciseCollectionService exerciseCollectionService;
    private UserService userService;
    private List<Integer> exerciseResults = new ArrayList<>();

    public ExerciseController(ExerciseCollectionService exerciseCollectionService, UserService userService) {
        this.exerciseCollectionService = exerciseCollectionService;
        this.userService = userService;
    }

    @GetMapping
    public String prepareExercisePage(@RequestParam Integer index, @RequestParam Long collectionId,
                                      Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("name", user.getName());

        int currentIndex=index;
        Optional<ExerciseCollection> optionalCollection = exerciseCollectionService.findById(collectionId);
        optionalCollection.ifPresent(collection -> {
            List<Exercise> exercises = collection.getExercises();
            if(currentIndex == 0 &&
                    (exerciseResults.size() == 0) || exerciseResults.stream().allMatch(element -> element == 0)) {
                exerciseResults.clear();
                for (Exercise exercise : exercises) {
                    exerciseResults.add(exercise.getRepetitionNumber());
                }
                model.addAttribute("results", exerciseResults);
                model.addAttribute("size", exercises.size());
            }
            model.addAttribute("collectionId", collectionId);
            model.addAttribute("exercise", exercises.get(currentIndex));
            model.addAttribute("index", currentIndex);
        });
        return "exercises";
    }

    @PostMapping
    public String processExercisePage(@ModelAttribute("results") List<Integer> exerciseResults,
                                      @ModelAttribute("size") Integer size,
                                      HttpSession session,
                                      @RequestParam Integer index, @RequestParam String answer,
                                      @RequestParam String correctAnswer, @RequestParam Long collectionId) {
        if (answer.equals(correctAnswer)) {
            exerciseResults.set(index, exerciseResults.get(index)-1);
        } else {
            exerciseResults.set(index, exerciseResults.get(index)+1);
        }
        System.out.println(exerciseResults);
        session.setAttribute("results", exerciseResults);
        int newIndex = 0;
        if (index < size-1) {
            newIndex = ++index;
        }
        while (exerciseResults.get(newIndex)==0) {
            if (!(exerciseResults.stream().allMatch(rep -> rep == 0)) && newIndex < size-1) {
                newIndex++;
            }else if (newIndex == size -1) {
                newIndex=0;
            } else {
                return "redirect:/student/learnt/"+collectionId;
            }
        }
        return "redirect:/student/exercise?index="+newIndex+"&collectionId="+collectionId;
    }
}
