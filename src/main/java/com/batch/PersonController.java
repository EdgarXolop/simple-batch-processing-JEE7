package com.batch;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.batch.runtime.BatchRuntime.getJobOperator;

import java.util.Properties;

@ApplicationScoped
@Path("/person")
public class PersonController{

    JobExecution jobExecution = null;

    @GET
    @Path("/start")
    @Produces("application/json")
    public String start(){
        JobOperator jobOperator = getJobOperator();
        String response = "";

        Long executionId = null;
                
        if(jobExecution == null){
            executionId = jobOperator.start("myJob", new Properties());

        }else{
            executionId = jobExecution.getExecutionId();
        }

        System.out.println("JOB EXECUTION ID : myJob " + executionId);
        
        jobExecution = jobOperator.getJobExecution(executionId);

        response = "{\"status\": "+jobExecution.getBatchStatus().toString()+", \"executionId\":\""+executionId+"\"}" ; 

        if(jobExecution.getBatchStatus().equals(BatchStatus.COMPLETED)
        || jobExecution.getBatchStatus().equals(BatchStatus.FAILED)
        || jobExecution.getBatchStatus().equals(BatchStatus.STOPPED)
        || jobExecution.getBatchStatus().equals(BatchStatus.ABANDONED)){
                jobExecution = null;
        }
        
        return  response;

    }
    
    @DELETE
    @Produces("application/json")
    @Path("/delete/{jobId}")
    public String delte(@PathParam("jobId")Long jobId){
        String response = "";

        getJobOperator().abandon(jobId);


        return response;
    }

}
