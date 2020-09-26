package pl.krzysztofskul.organization.hospital;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.krzysztofskul.AppConfig;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class HospitalServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserService userService;

    @Autowired
    private HospitalService hospitalService;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void whenAddHospitalToUserManagingList_shouldEntitiesBeUpdatedInDb() {

        // given
        userService.save(new User());
        int j = 3;
        for (int i = 0; i < j ; i++) {
            hospitalService.save(new Hospital());
        }

        // when
        User user = userService.loadByIdWithHospitalsManagingList(Long.parseLong("1"));
        for (int i = 0; i < j ; i++) {
            Hospital hospital = hospitalService.loadById(Long.parseLong(String.valueOf(i+1)));
            hospitalService.addHospitalToUserManagingList(hospital.getId(), user.getId());
        }

        // should
        assertEquals(j, userService.loadByIdWithHospitalsManagingList(Long.parseLong("1")).getHospitalManagingList().size());

    }
}