package com.dragonball.common.context;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(Include.NON_NULL)
@JsonSerialize(
        include = Inclusion.NON_NULL
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public abstract class AbstractBaseDTO {

    public AbstractBaseDTO() {
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}