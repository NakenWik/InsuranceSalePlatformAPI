package com.nkdev.isp.service;

import com.nkdev.isp.model.ApplicationModel;
import com.nkdev.isp.repo.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepo applicationRepo;

    public Iterable<ApplicationModel> getAllApplication(){
        Iterable<ApplicationModel> result =  applicationRepo.findAll();
        return result;
    }
    public ApplicationModel submitApplication(ApplicationModel applicationModel){
        return applicationRepo.save(applicationModel);
    }

    public void deleteAllApplication(){
        applicationRepo.deleteAll();
    }

    public void deleteApplication(Long Id){

        Optional<ApplicationModel> applicationModel = applicationRepo.findById(Id);
        if(applicationModel.isPresent()){
            applicationRepo.delete(applicationModel.get());
        }

    }
}
