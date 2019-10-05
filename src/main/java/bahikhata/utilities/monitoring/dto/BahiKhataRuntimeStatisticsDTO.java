/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.monitoring.dto;

import bahikhata.utilities.monitoring.constants.BahiKhataMonitoringConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is model class for Runtime Statistics
 * 
 * @author Neeraj.Jain
 * @since 5-Oct-2019
 * @version 1.0
 */
@ApiModel(description = BahiKhataMonitoringConstants.BAHIKHATA_RUNTIME_STATISTICS_CLASS_DESCRIPTION, reference = "BahiKhataMemoryStatsticsDTO")
public class BahiKhataRuntimeStatisticsDTO
{
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_RUNTIME_STATISTICS_BOOT_CLASSPATH_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_RUNTIME_STATISTICS_BOOT_CLASSPATH_VALUE)
    private String bootClassPath;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_RUNTIME_STATISTICS_CLASSPATH_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_RUNTIME_STATISTICS_CLASSPATH_VALUE)
    private String classPath;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_RUNTIME_STATISTICS_LIBRARY_PATH_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_RUNTIME_STATISTICS_LIBRARY_PATH_VALUE)
    private String libraryPath;

    public BahiKhataRuntimeStatisticsDTO(String bootClassPath, String classPath, String libraryPath)
    {
        this.bootClassPath = bootClassPath;
        this.classPath = classPath;
        this.libraryPath = libraryPath;
    }

    public BahiKhataRuntimeStatisticsDTO()
    {
    }

    public String getBootClassPath()
    {
        return bootClassPath;
    }

    public void setBootClassPath(String bootClassPath)
    {
        this.bootClassPath = bootClassPath;
    }

    public String getClassPath()
    {
        return classPath;
    }

    public void setClassPath(String classPath)
    {
        this.classPath = classPath;
    }

    public String getLibraryPath()
    {
        return libraryPath;
    }

    public void setLibraryPath(String libraryPath)
    {
        this.libraryPath = libraryPath;
    }

    @Override
    public String toString()
    {
        return "BahiKhataRuntimeStatisticsDTO [bootClassPath=" + bootClassPath + ", classPath="
                + classPath + ", libraryPath=" + libraryPath + "]";
    }

}
