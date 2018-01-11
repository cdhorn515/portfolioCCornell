package com.cdhorn.ControllerTests;


import com.cdhorn.Controllers.Projects;
import com.cdhorn.Interfaces.ProjectRepository;
import com.cdhorn.PortfolioApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PortfolioApplication.class)
@ActiveProfiles(profiles = "test")
public class ProjectsTests {

    private MockMvc mockMvc;

    @Autowired
    ProjectRepository projectRepoTest;

    @Autowired
    private GenericEntityRepository genericEntityRepository;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new Projects())
                .addPlaceholderValue("project", "1")
                .build();
    }

    @Test
    public void givenGenericEntityRepository_whenSaveAndRetrieveEntity_thenOK() {
        GenericEntity genericEntity = genericEntityRepository
                .save(new GenericEntity("test"));
        GenericEntity foundEntity = genericEntityRepository
                .findOne(genericEntity.getId());

        assertNotNull(foundEntity);
        assertEquals(genericEntity.getValue(), foundEntity.getValue());
    }

    @Test
    public void testProjectsPageStatus() throws Exception {

        mockMvc.perform(get("/projects"))
                .andExpect(status().isOk())
                .andExpect(view().name("project"));
    }
}
