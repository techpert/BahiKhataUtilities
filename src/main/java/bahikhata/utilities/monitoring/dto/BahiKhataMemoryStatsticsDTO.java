package bahikhata.utilities.monitoring.dto;

import java.lang.management.MemoryUsage;
import java.util.Objects;

public class BahiKhataMemoryStatsticsDTO
{
    private MemoryUsage nonHeapMemoryUsage;
    private MemoryUsage heapMemoryUsage;

    public BahiKhataMemoryStatsticsDTO(MemoryUsage nonHeapMemoryUsage, MemoryUsage heapMemoryUsage)
    {
        super();
        this.nonHeapMemoryUsage = nonHeapMemoryUsage;
        this.heapMemoryUsage = heapMemoryUsage;
    }

    public BahiKhataMemoryStatsticsDTO()
    {
        super();
    }

    public MemoryUsage getNonHeapMemoryUsage()
    {
        return nonHeapMemoryUsage;
    }

    public void setNonHeapMemoryUsage(MemoryUsage nonHeapMemoryUsage)
    {
        this.nonHeapMemoryUsage = nonHeapMemoryUsage;
    }

    public MemoryUsage getHeapMemoryUsage()
    {
        return heapMemoryUsage;
    }

    public void setHeapMemoryUsage(MemoryUsage heapMemoryUsage)
    {
        this.heapMemoryUsage = heapMemoryUsage;
    }

    @Override
    public String toString()
    {
        return "BahiKhataMemoryStatsticsDTO [nonHeapMemoryUsage=" + nonHeapMemoryUsage
                + ", heapMemoryUsage=" + heapMemoryUsage + "]";
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(heapMemoryUsage, nonHeapMemoryUsage);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BahiKhataMemoryStatsticsDTO other = (BahiKhataMemoryStatsticsDTO) obj;
        return Objects.equals(heapMemoryUsage, other.heapMemoryUsage)
                && Objects.equals(nonHeapMemoryUsage, other.nonHeapMemoryUsage);
    }

}
