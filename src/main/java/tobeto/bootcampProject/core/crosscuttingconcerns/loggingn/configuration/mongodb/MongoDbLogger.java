package tobeto.bootcampProject.core.crosscuttingconcerns.loggingn.configuration.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.core.crosscuttingconcerns.loggingn.LogDetail;
import tobeto.bootcampProject.core.crosscuttingconcerns.loggingn.LogParameter;
import tobeto.bootcampProject.core.crosscuttingconcerns.loggingn.LoggerServiceBase;

import java.util.List;

@Service
public class MongoDbLogger extends LoggerServiceBase {
	
	private MongoTemplate mongoTemplate;
	
	@Autowired
	public MongoDbLogger(MongoTemplate mongoTemplate) {
		super(MongoDbLogger.class);
		this.mongoTemplate=mongoTemplate;
	}

	@Override
	public void log(String methodName, List<LogParameter> logParameters, String userName) {
		LogDetail detail = new LogDetail();
		detail.setMethodName(methodName);
		detail.setParameters(logParameters);
		detail.setUser(userName);
		info(detail.toString());
		mongoTemplate.save(detail);
		
	}

}
