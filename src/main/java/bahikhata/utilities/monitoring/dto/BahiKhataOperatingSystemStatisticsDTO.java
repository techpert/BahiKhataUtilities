/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.monitoring.dto;

import bahikhata.utilities.monitoring.constants.BahiKhataMonitoringConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is model class for Operating System Statistics
 * 
 * @author Neeraj.Jain
 * @since 5-Oct-2019
 * @version 1.0
 */
@ApiModel(description = BahiKhataMonitoringConstants.BAHIKHATA_OPERATING_SYSTEM_STATISTICS_CLASS_DESCRIPTION, reference = "BahiKhataOperatingSystemStatisticsDTO")
public class BahiKhataOperatingSystemStatisticsDTO
{
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_OPERATING_SYSTEM_STATISTICS_OPERATING_SYSTEM_NAME_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_OPERATING_SYSTEM_STATISTICS_OPERATING_SYSTEM_NAME_VALUE)
    private String operatingSystemName;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_OPERATING_SYSTEM_STATISTICS_AVAILABLE_PROCESSORS_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_OPERATING_SYSTEM_STATISTICS_AVAILABLE_PROCESSORS_VALUE)
    private int availableProcessors;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_OPERATING_SYSTEM_STATISTICS_JVM_CPU_USAGE_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_OPERATING_SYSTEM_STATISTICS_JVM_CPU_USAGE_VALUE)
    private String jvmCPUUsage;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_OPERATING_SYSTEM_STATISTICS_SYSTEM_CPU_USAGE_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_OPERATING_SYSTEM_STATISTICS_SYSTEM_CPU_USAGE_VALUE)
    private String systemCPUUsage;

    public BahiKhataOperatingSystemStatisticsDTO()
    {
    }

    public BahiKhataOperatingSystemStatisticsDTO(String operatingSystemName, int processor,
            String jvmCPUUsage, String systemCPUUsage)
    {
        this.operatingSystemName = operatingSystemName;
        this.availableProcessors = processor;
        this.jvmCPUUsage = jvmCPUUsage;
        this.systemCPUUsage = systemCPUUsage;
    }

    public String getOperatingSystemName()
    {
        return operatingSystemName;
    }

    public void setOperatingSystemName(String operatingSystemName)
    {
        this.operatingSystemName = operatingSystemName;
    }

    public int getAvailableProcessors()
    {
        return availableProcessors;
    }

    public void setAvailableProcessors(int availableProcessors)
    {
        this.availableProcessors = availableProcessors;
    }

    public String getJvmCPUUsage()
    {
        return jvmCPUUsage;
    }

    public void setJvmCPUUsage(String jvmCPUUsage)
    {
        this.jvmCPUUsage = jvmCPUUsage;
    }

    public String getSystemCPUUsage()
    {
        return systemCPUUsage;
    }

    public void setSystemCPUUsage(String systemCPUUsage)
    {
        this.systemCPUUsage = systemCPUUsage;
    }

    @Override
    public String toString()
    {
        return "BahiKhataOperatingSystemStatisticsDTO [OperatingSystemName=" + operatingSystemName
                + ", processor=" + availableProcessors + ", jvmCPUUsage=" + jvmCPUUsage
                + ", systemCPUUsage=" + systemCPUUsage + "]";
    }

}
