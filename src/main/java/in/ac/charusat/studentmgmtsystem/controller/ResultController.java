package in.ac.charusat.studentmgmtsystem.controller;


import in.ac.charusat.studentmgmtsystem.model.Result;
import in.ac.charusat.studentmgmtsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ResultController {

    @Autowired
    ResultRepository resultRepository;
//    List<Result> results = new ArrayList<>(
//            Arrays.asList(
//                    new Result(1, "Tom", (float) 90.05)
//
//            )
//    );


    //Get the list of result
    @GetMapping("/listResults")
    public List<Result> getAllResults(){
        return resultRepository.findAll();
    }

    @GetMapping("/result/{id}")
    public Result getResult(@PathVariable Integer id){
        return  resultRepository.findById(id).get();
    }

    @PostMapping("/result")
    public List<Result> addResult(@RequestBody Result result){
        resultRepository.save(result);
        return  resultRepository.findAll();
    }

    @PutMapping("/result/{id}")
    public List<Result> updateResult(@RequestBody  Result result, @PathVariable Integer id){
        Result resultObj = resultRepository.findById(id).get();
        resultObj.setName(result.getName());
        resultObj.setPercentage(result.getPercentage());
        resultRepository.save(resultObj);
        return  resultRepository.findAll();
    }


    @DeleteMapping("/result/{id}")
    public List<Result> deleteResult(@PathVariable Integer id)
    {
        resultRepository.delete(resultRepository.findById(id).get());
        return resultRepository.findAll();
    }
}