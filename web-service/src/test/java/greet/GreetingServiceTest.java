package greet;

import com.zackku.common.LogUtil;
import com.zackku.service.helllo.domain.Greeting;
import com.zackku.service.helllo.mapper.GreetingMapper;
import com.zackku.service.helllo.service.GreetingService;
import com.zackku.service.helllo.service.impl.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * @author Zack
 * @date 2018/5/10
 */
public class GreetingServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServiceTest.class);

    @InjectMocks
    private GreetingServiceImpl greetingServiceImpl;
    @Mock
    private GreetingMapper greetingMapper;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAGreet() {
        Long id = 1L;
        mockFindAGreet(id);
        Greeting greeting = greetingServiceImpl.findGreat(id);
        LogUtil.info(LOGGER, "find greet test", "greet:{}", greeting.toString());
        verify(greetingMapper, times(1)).findOne(1L);
    }

    private void mockFindAGreet(Long id) {
        Greeting greeting = new Greeting();
        greeting.setId(id);
        greeting.setContent("This is a test greet!");
        when(greetingMapper.findOne(1L)).thenReturn(greeting);
    }

}
