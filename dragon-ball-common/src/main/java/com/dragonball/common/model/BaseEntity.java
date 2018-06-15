package com.dragonball.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonSerialize(
        include = Inclusion.NON_NULL
)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEntity implements Serializable, IEntity, Comparable<IEntity>  {
    private static final long serialVersionUID = 1L;

    /**
     * 所有Entity都必须具有Long类型的主键
     */
    protected Long id;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     * the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 重载Entity类的toString()方法 返回Entity类所有属性值
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return id == null ? System.identityHashCode(this) : id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass().getPackage() != obj.getClass().getPackage()) {
            return false;
        }
        if (IEntity.class.isAssignableFrom((obj.getClass()))) {
            final BaseEntity other = (BaseEntity) obj;
            if (id == null) {
                if (other.getId() != null) {
                    return false;
                }
            } else if (!id.equals(other.getId())) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(IEntity o) {
        if (null == o) {
            return 0;
        }
        return (o.equals(this) ? 0 : 1);
    }
}
