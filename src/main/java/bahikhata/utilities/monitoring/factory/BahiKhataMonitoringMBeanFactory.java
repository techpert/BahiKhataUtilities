package bahikhata.utilities.monitoring.factory;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.cache.CacheManager;
import javax.cache.management.CacheStatisticsMXBean;
import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bahikhata.utilities.monitoring.exception.BahiKhataStatsticsBeanException;
@Component
final public class BahiKhataMonitoringMBeanFactory
{
    @Autowired
    CacheManager cacheManager;
    public static final String JAVA_MEMORY_MXBEAN_OBJECT_NAME = "java.lang:type=Memory";
    public static final String CACHE_MXBEAN_OBJECT_NAME = "javax.cache:type=CacheStatistics,*,Cache=";
    public static final String OPERATING_SYSTEM_MXBEAN_OBJECT_NAME = "java.lang:type=OperatingSystem";
    public static final String GARBAGE_COLLECTION_AGGREGATOR_MXBEAN_OBJECT_NAME = "com.sun.management:type=GarbageCollectionAggregator";
    final static MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();

    public final  List<CacheStatisticsMXBean> getCacheStatisticsMXBeans()
            throws BahiKhataStatsticsBeanException
    {
        List<CacheStatisticsMXBean> cacheStatisticsMXBeansList = new ArrayList<>();
        Iterable<String> cacheNames = cacheManager.getCacheNames();
        Iterator<String> cacheNamesIterator = cacheNames.iterator();
        while (cacheNamesIterator.hasNext())
        {
            cacheStatisticsMXBeansList.add(getCacheStatisticsMXBean(cacheNamesIterator.next()));
        }
        return cacheStatisticsMXBeansList;
    }

    public final  CacheStatisticsMXBean getCacheStatisticsMXBean(String cacheName)
            throws BahiKhataStatsticsBeanException
    {
        return getMonitoringBean(CACHE_MXBEAN_OBJECT_NAME + cacheName, CacheStatisticsMXBean.class);
    }

    public final  GarbageCollectorMXBean getGarbageCollectorMXBean()
            throws BahiKhataStatsticsBeanException
    {

        return getMonitoringBean(GARBAGE_COLLECTION_AGGREGATOR_MXBEAN_OBJECT_NAME,
                GarbageCollectorMXBean.class);
    }

    public final  MemoryMXBean getMemoryMXBean() throws BahiKhataStatsticsBeanException
    {
        return getMonitoringBean(JAVA_MEMORY_MXBEAN_OBJECT_NAME, MemoryMXBean.class);

    }

    public final  OperatingSystemMXBean getOperatingSystemMXBean()
            throws BahiKhataStatsticsBeanException
    {

        return getMonitoringBean(OPERATING_SYSTEM_MXBEAN_OBJECT_NAME, OperatingSystemMXBean.class);

    }

    private final  <T> T getMonitoringBean(String objectName, Class<T> monitoringBean)
            throws BahiKhataStatsticsBeanException
    {
        ObjectName mBeanName = null;
        try
        {
            mBeanName = new ObjectName(objectName);
            if (!mbeanServer.isRegistered(mBeanName))
            {
                throw new BahiKhataStatsticsBeanException(
                        "The Object is not registered with MBean Server: "+objectName);
            }
        }
        catch (MalformedObjectNameException e)
        {
            throw new BahiKhataStatsticsBeanException(
                    "Object Name used to query MBean is incorrect or malformed: "+objectName, e);
        }
        return JMX.newMBeanProxy(mbeanServer, mBeanName, monitoringBean);
    }
}
