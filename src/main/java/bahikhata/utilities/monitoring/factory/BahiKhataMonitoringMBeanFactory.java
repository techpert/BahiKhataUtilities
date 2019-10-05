/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.monitoring.factory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.RuntimeMXBean;
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

import com.sun.management.OperatingSystemMXBean;

import bahikhata.utilities.monitoring.exception.BahiKhataStatsticsBeanException;

/**
 * Techpert:Bahikhata : 0.0.1 :This class will act as factory of MXbeans and fetch MXbeans from Mbean manager and
 * 
 * @author Neeraj Jain
 * @see MBeanServer
 * @since Oct 05,2019
 * @version 0.0.1
 */
@Component
final public class BahiKhataMonitoringMBeanFactory
{

    CacheManager cacheManager;
    public static final String CACHE_MXBEAN_OBJECT_NAME = "javax.cache:type=CacheStatistics,CacheManager=urn.X-ehcache.jsr107-default-config,Cache=";
    final static MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();

    /**
     * Techpert:Bahikhata : 0.0.1 :This method evict all caches
     * 
     * @since 05 Oct 2019
     * @return List<CacheStatisticsMXBean>
     * @see CacheStatisticsMXBean
     * @throws BahiKhataStatsticsBeanException
     */
    public final List<CacheStatisticsMXBean> getCacheStatisticsMXBeans()
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

    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetch CacheStatisticsMXBean
     * 
     * @since 05 Oct 2019
     * @return {@link CacheStatisticsMXBean}
     * @throws BahiKhataStatsticsBeanException
     */
    public final CacheStatisticsMXBean getCacheStatisticsMXBean(String cacheName)
            throws BahiKhataStatsticsBeanException
    {
        return getMonitoringBean(CACHE_MXBEAN_OBJECT_NAME + cacheName, CacheStatisticsMXBean.class);
    }
    
    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetch MemoryMXBean RuntimeMXBean
     * 
     * @since 05 Oct 2019
     * @return {@link RuntimeMXBean}
     * @throws BahiKhataStatsticsBeanException
     */
    public final RuntimeMXBean getGarbageRuntimeMXBean() throws BahiKhataStatsticsBeanException
    {
        return ManagementFactory.getRuntimeMXBean();
    }

    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetch MemoryMXBean
     * 
     * @since 05 Oct 2019
     * @return {@link MemoryMXBean}
     * @throws BahiKhataStatsticsBeanException
     */
    public final MemoryMXBean getMemoryMXBean() throws BahiKhataStatsticsBeanException
    {
        
        return ManagementFactory.getMemoryMXBean();
    }

    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetch OperatingSystemMXBean
     * 
     * @since 05 Oct 2019
     * @return {@link OperatingSystemMXBean
     * @throws BahiKhataStatsticsBeanException
     */
    public final OperatingSystemMXBean getOperatingSystemMXBean()
            throws BahiKhataStatsticsBeanException
    {
        return ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
    }

    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetch Monitoring bean (MXBean) from MBean manager
     * 
     * @since 05 Oct 2019
     * @param objectName
     * @param monitoringBean
     * @return monitoringBean of Type T 
     * @throws BahiKhataStatsticsBeanException
     */
    private final <T> T getMonitoringBean(String objectName, Class<T> monitoringBean)
            throws BahiKhataStatsticsBeanException
    {
        ObjectName mBeanName = null;
        try
        {
            mBeanName = new ObjectName(objectName);
            if (!mbeanServer.isRegistered(mBeanName))
            {
                throw new BahiKhataStatsticsBeanException(
                        "The Object is not registered with MBean Server: " + objectName);
            }
        }
        catch (MalformedObjectNameException e)
        {
            throw new BahiKhataStatsticsBeanException(
                    "Object Name used to query MBean is incorrect or malformed: " + objectName, e);
        }
        return JMX.newMBeanProxy(mbeanServer, mBeanName, monitoringBean);
    }

    public CacheManager getCacheManager()
    {
        return cacheManager;
    }

    @Autowired
    public void setCacheManager(CacheManager cacheManager)
    {
        this.cacheManager = cacheManager;
    }
}
