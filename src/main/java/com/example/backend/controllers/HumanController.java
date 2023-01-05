package com.example.backend.controllers;


import com.example.backend.model.Human;
import com.example.backend.repositories.HumanRepositories;
import com.example.backend.response.CommonResponse;
import com.example.backend.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/human")
public class HumanController {

    @Autowired
    HumanRepositories humanRepositories;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;


    @GetMapping(value = "/cekapi")
    public CommonResponse<String> cekapi(){
        return commonResponseGenerator.successResponse("hello api", "Success");
    }

    @PostMapping(value = "addhuman")
    public CommonResponse<Human> addHuman(@RequestBody Human param){
        humanRepositories.save(param);
        return commonResponseGenerator.successResponse(param, "success add new ");
    }

    @GetMapping(value = "getallhuman")
    public CommonResponse<List<Human>> getAllCar(){
        return commonResponseGenerator.successResponse(humanRepositories.findAll(), "Success get all");
    }

    @GetMapping(value = "getbyid")
    public CommonResponse<List<Human>> getbyid(@RequestParam int id){
        return commonResponseGenerator.successResponse(humanRepositories.findById(id).get(), "Success get by id");
    }

    @PutMapping(value = "updatehuman")
    public CommonResponse<Human> updateHuman(@RequestBody Human param){
        return commonResponseGenerator.successResponse(humanRepositories.save(param), "success Update data id " + param.getId());
    }

    @DeleteMapping(value = "deletehuman")
    public CommonResponse<List<Human>> delete(@RequestParam int id){
//        Human human = humanRepositories.findById(id).get();
        humanRepositories.deleteById(id);
        // menampilkan islist yg ada saja
        List<Human> humanList = humanRepositories.findAll();
        return commonResponseGenerator.successResponse(humanList, "Success delete id ");
    }

}
