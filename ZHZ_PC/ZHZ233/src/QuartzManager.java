import org.quartz.CronTrigger;  
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;  
import org.quartz.SchedulerFactory;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

public class QuartzManager {  
    private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();  
    private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";  
    private static String TRIGGER_GROUP_NAME = "EXTJWEB_TRIGGERGROUP_NAME";  
  
    /** 
     * ����һ����ʱ����ʹ��Ĭ�ϵ������������������������������� 
     * @param jobName ������ 
     * @param cls ���� 
     * @param time ʱ������ 
     */  
    @SuppressWarnings("rawtypes")  
    public static void addJob(String jobName, Class cls, String time) {  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();
            TriggerKey T = new TriggerKey(jobName, TRIGGER_GROUP_NAME);
            JobKey J = new JobKey(jobName, JOB_GROUP_NAME);
            // �������������飬����ִ����  
            JobDetail jobDetail = new JobDetailImpl(jobName, JOB_GROUP_NAME, cls);  
            //���Դ��ݲ���  
            jobDetail.getJobDataMap().put("param", "railsboy"); 
            jobDetail.getJobDataMap().put("jobName", jobName); 
            // ������  
            CronTrigger trigger = new CronTriggerImpl(jobName, TRIGGER_GROUP_NAME);  
            // ��������,��������  
           
            ((CronTriggerImpl) trigger).setCronExpression(time);  
            // ������ʱ���趨  
            sched.scheduleJob(jobDetail, trigger);  
            // ����  
            if (!sched.isShutdown()) {  
                sched.start();  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
    /** 
     * �޸�һ������Ĵ���ʱ��(ʹ��Ĭ�ϵ�������������������������������) 
     * @param jobName 
     * @param time 
     */  
    @SuppressWarnings("rawtypes")  
    public static void modifyJobTime(String jobName, String time) {  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler(); 
            TriggerKey T = new TriggerKey(jobName, TRIGGER_GROUP_NAME);
            JobKey J = new JobKey(jobName, JOB_GROUP_NAME);
            CronTrigger trigger = (CronTrigger) sched.getTrigger(T);  
            if (trigger == null) {  
                return;  
            }  
            String oldTime = trigger.getCronExpression();  
            if (!oldTime.equalsIgnoreCase(time)) {  
                JobDetail jobDetail = sched.getJobDetail(J);  
                Class objJobClass = jobDetail.getJobClass();  
                removeJob(jobName);  
                addJob(jobName, objJobClass, time);  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
  
    /** 
     * �Ƴ�һ������(ʹ��Ĭ�ϵ�������������������������������) 
     * @param jobName 
     */  
    public static void removeJob(String jobName) {  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            TriggerKey T = new TriggerKey(jobName, TRIGGER_GROUP_NAME);
            JobKey J = new JobKey(jobName, JOB_GROUP_NAME);
            sched.pauseTrigger(T);// ֹͣ������  
            sched.unscheduleJob(T);// �Ƴ�������  
            sched.deleteJob(J);// ɾ������  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * �������ж�ʱ���� 
     */  
    public static void startJobs() {  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            sched.start();  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * �ر����ж�ʱ���� 
     */  
    public static void shutdownJobs() {  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            if (!sched.isShutdown()) {  
                sched.shutdown();  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
} 