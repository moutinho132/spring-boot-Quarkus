package com.example;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @GET
    public List<Task> getAllTasks() {
        return Task.listAll();
    }

    @POST
    @Transactional
    public Task createTask(Task task) {
        task.persist();
        return task;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Task updateTask(@PathParam("id") Long id, Task updatedTask) {
        Task task = Task.findById(id);
        if (task == null) {
            throw new WebApplicationException("Task not found", 404);
        }
        task.title = updatedTask.title;
        task.description = updatedTask.description;
        task.completed = updatedTask.completed;
        return task;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteTask(@PathParam("id") Long id) {
        Task.deleteById(id);
    }
}