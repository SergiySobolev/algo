package algo.sorting;

import com.sbk.algo.config.DataBaseConfig;
import com.sbk.algo.config.WebAppConfig;
import com.sbk.algo.config.WebAppInitializer;
import com.sbk.algo.server.entity.PrincipalEntity;
import com.sbk.algo.server.repo.PrincipalRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsNot.not;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppInitializer.class, WebAppConfig.class, DataBaseConfig.class})
public class AuthRepoTest {

    @Autowired
    private PrincipalRepository principalRepository;

    @Test
    public void baseTest() {
        assertThat(principalRepository, notNullValue());
        assertThat(principalRepository, not(nullValue()));
    }

    @Test
    @Transactional
    public void getUserWithId1() {
        PrincipalEntity principal1 = principalRepository.getOne(1L);
        PrincipalEntity principal2 = principalRepository.findPrincipalById(1L);
        PrincipalEntity principal3 = principalRepository.findPrincipalByLogin("fabrizio");
        assertThat(principal1, equalTo(principal2));
        assertThat(principal1, equalTo(principal3));
    }
}
