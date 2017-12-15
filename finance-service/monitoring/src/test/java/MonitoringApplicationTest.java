import com.finance.service.MonitoringApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MonitoringApplication.class)
public class MonitoringApplicationTest {

	@Autowired
	private ApplicationContext context;

	@Test
	public void contextLoads() {

	}

}
