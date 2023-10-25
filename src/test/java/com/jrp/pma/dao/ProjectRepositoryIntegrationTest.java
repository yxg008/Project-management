package com.jrp.pma.dao;



import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrp.pma.ProjectManagementApplication;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;
 
@SpringBootTest // *Annotation required to write the test
//@ContextConfiguration(classes = ProjectManagementApplication.class)  // starting point, load the spring context and bring in all the beans, able to auto wire
@RunWith(SpringRunner.class)
//@DataJpaTest // temporary database write test cases with
public class ProjectRepositoryIntegrationTest {
 
    @Autowired
    ProjectRepository projectRepository;// class ProjectRepository get injected
 
    @Test
    public void ifNewProjectSaved_thenSuccess() {
        Project newProject = new Project("Test Project 1", "COMPLETE", "Generic description");
        projectRepository.save(newProject);
        assertEquals(5, projectRepository.findAll().size());
    }
}