/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.monitoring.dto;

import bahikhata.utilities.monitoring.constants.BahiKhataMonitoringConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is model class for Memory Statistics
 * 
 * @author Neeraj.Jain
 * @since 5-Oct-2019
 * @version 1.0
 */
@ApiModel(description = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_CLASS_DESCRIPTION, reference = "BahiKhataMemoryStatsticsDTO")
public class BahiKhataMemoryStatsticsDTO
{
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_INITIAL_NON_HEAPMEMORY_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_INITIAL_NON_HEAPMEMORY_VALUE)
    private String initialNonHeapMemory;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_USED_NON_HEAPMEMORY_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_USED_NON_HEAPMEMORY_VALUE)
    private String usedNonHeapMemory;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_COMMITTED_NON_HEAPMEMORY_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_COMMITTED_NON_HEAPMEMORY_VALUE)
    private String committedNonHeapMemory;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_MAX_NON_HEAP_MEMORY_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_MAX_NON_HEAP_MEMORY_VALUE)
    private String maxNonHeapMemory;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_INITIAL_HEAP_MEMORY_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_INITIAL_HEAP_MEMORY_VALUE)
    private String initialHeapMemory;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_USED_HEAP_MEMORY_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_USED_HEAP_MEMORY_VALUE)
    private String usedHeapMemory;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_COMMITTED_HEAP_MEMORY_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_COMMITTED_HEAP_MEMORY_VALUE)
    private String committedHeapMemory;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_MAX_HEAP_MEMORY_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_MEMORY_STATISTICS_MAX_HEAP_MEMORY_VALUE)
    private String maxHeapMemory;

    public BahiKhataMemoryStatsticsDTO()
    {
    }

    public BahiKhataMemoryStatsticsDTO(String initialNonHeapMemory, String usedNonHeapMemory,
            String committedNonHeapMemory, String maxNonHeapMemory, String initialHeapMemory,
            String usedHeapMemory, String committedHeapMemory, String maxHeapMemory)
    {
        this.initialNonHeapMemory = initialNonHeapMemory;
        this.usedNonHeapMemory = usedNonHeapMemory;
        this.committedNonHeapMemory = committedNonHeapMemory;
        this.maxNonHeapMemory = maxNonHeapMemory;
        this.initialHeapMemory = initialHeapMemory;
        this.usedHeapMemory = usedHeapMemory;
        this.committedHeapMemory = committedHeapMemory;
        this.maxHeapMemory = maxHeapMemory;
    }

    public String getInitialNonHeapMemory()
    {
        return initialNonHeapMemory;
    }

    public void setInitialNonHeapMemory(String initialNonHeapMemory)
    {
        this.initialNonHeapMemory = initialNonHeapMemory;
    }

    public String getUsedNonHeapMemory()
    {
        return usedNonHeapMemory;
    }

    public void setUsedNonHeapMemory(String usedNonHeapMemory)
    {
        this.usedNonHeapMemory = usedNonHeapMemory;
    }

    public String getCommittedNonHeapMemory()
    {
        return committedNonHeapMemory;
    }

    public void setCommittedNonHeapMemory(String committedNonHeapMemory)
    {
        this.committedNonHeapMemory = committedNonHeapMemory;
    }

    public String getMaxNonHeapMemory()
    {
        return maxNonHeapMemory;
    }

    public void setMaxNonHeapMemory(String maxNonHeapMemory)
    {
        this.maxNonHeapMemory = maxNonHeapMemory;
    }

    public String getInitialHeapMemory()
    {
        return initialHeapMemory;
    }

    public void setInitialHeapMemory(String initialHeapMemory)
    {
        this.initialHeapMemory = initialHeapMemory;
    }

    public String getUsedHeapMemory()
    {
        return usedHeapMemory;
    }

    public void setUsedHeapMemory(String usedHeapMemory)
    {
        this.usedHeapMemory = usedHeapMemory;
    }

    public String getCommittedHeapMemory()
    {
        return committedHeapMemory;
    }

    public void setCommittedHeapMemory(String committedHeapMemory)
    {
        this.committedHeapMemory = committedHeapMemory;
    }

    public String getMaxHeapMemory()
    {
        return maxHeapMemory;
    }

    public void setMaxHeapMemory(String maxHeapMemory)
    {
        this.maxHeapMemory = maxHeapMemory;
    }

    @Override
    public String toString()
    {
        return "BahiKhataMemoryStatsticsDTO [initialNonHeapMemory=" + initialNonHeapMemory
                + ", usedNonHeapMemory=" + usedNonHeapMemory + ", committedNonHeapMemory="
                + committedNonHeapMemory + ", maxNonHeapMemory=" + maxNonHeapMemory
                + ", initialHeapMemory=" + initialHeapMemory + ", usedHeapMemory=" + usedHeapMemory
                + ", committedHeapMemory=" + committedHeapMemory + ", maxHeapMemory="
                + maxHeapMemory + "]";
    }

}
