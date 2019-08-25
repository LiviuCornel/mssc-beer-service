package com.example.msscbeerservice.configuration;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import ch.qos.logback.core.util.FileSize;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@Configuration
@PropertySource("classpath:logging.properties")
public class LoggingConfig {
	
	public LoggingConfig(Environment env
			) {
       
		try {	
        	LoggerContext logCtx = (LoggerContext) LoggerFactory.getILoggerFactory();
        	
        	ConsoleAppender<ILoggingEvent> logConsoleAppender = getConsoleAppender(env, logCtx);
           
        	RollingFileAppender<ILoggingEvent> logFileAppender = getFileAppender(env, logCtx,
        			"log", env.getProperty("patternFile"));
            Logger logRoot = logCtx.getLogger(Logger.ROOT_LOGGER_NAME);
            logRoot.setAdditive(false);
            logRoot.setLevel(Level.valueOf(env.getProperty("levelLog")));
            logRoot.addAppender(logConsoleAppender);
            logRoot.addAppender(logFileAppender);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	private RollingFileAppender<ILoggingEvent> getFileAppender(Environment env, LoggerContext logCtx, String nomeFile, String pattern) {
		//encoder per l'appender rolling
		PatternLayoutEncoder logEncoderRolling = new PatternLayoutEncoder();
		logEncoderRolling.setContext(logCtx);
		logEncoderRolling.setPattern(pattern);
		logEncoderRolling.start();
		//Appender che stampa su file 
		RollingFileAppender<ILoggingEvent> logFileAppender = new RollingFileAppender<>();
		logFileAppender.setContext(logCtx);
		logFileAppender.setName(nomeFile);
		logFileAppender.setEncoder(logEncoderRolling);
		logFileAppender.setAppend(true);
		logFileAppender.setFile(env.getProperty("logPath")+nomeFile+".log");
		SizeAndTimeBasedRollingPolicy<ILoggingEvent> sizeAndTime = new SizeAndTimeBasedRollingPolicy<>();
		sizeAndTime.setContext(logCtx);
		sizeAndTime.setParent(logFileAppender);
		sizeAndTime.setFileNamePattern(env.getProperty("logPath")+nomeFile+"-%d{yyyy-MM-dd}.%i.log");
		sizeAndTime.setMaxFileSize(FileSize.valueOf(env.getProperty("maxSizeLogFile")));
		sizeAndTime.start();
		logFileAppender.setRollingPolicy(sizeAndTime); //Imposta le regole di rolling
		logFileAppender.start();
		return logFileAppender;
	}

	private ConsoleAppender<ILoggingEvent> getConsoleAppender(Environment env, LoggerContext logCtx) {
		PatternLayoutEncoder logEncoder = new PatternLayoutEncoder();
		logEncoder.setContext(logCtx);
		logEncoder.setPattern(env.getProperty("patternConsole"));
		logEncoder.start();
		ConsoleAppender<ILoggingEvent> logConsoleAppender = new ConsoleAppender<>();
		logConsoleAppender.setContext(logCtx);
		logConsoleAppender.setName("console");
		logConsoleAppender.setEncoder(logEncoder);
		logConsoleAppender.start();
		return logConsoleAppender;
	}
}