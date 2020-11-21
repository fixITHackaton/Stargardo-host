package pl.fixit.starogardo.host.company.strategy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;
import pl.fixit.starogardo.host.company.CompanyServiceStrategy;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CompanyServiceStrategyTest {

    @Autowired
    CompanyServiceStrategy companyServiceStrategy;

    @Test
    public void shouldReturnRestaurantService() {
        Assert.assertEquals(companyServiceStrategy.selectService(CompanyCategory.FOOD).getClass().getSimpleName(),
                "RestaurantServiceImpl");
    }
}
