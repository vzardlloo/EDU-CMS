package com.vzard.educms.util

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition

interface ModelMetaInfo{

    @JsonIgnore
    fun `$getModelMap`(): Map<String,Any>

    @JsonIgnore
    fun `$getModelProperties`(): Map<String,BeanPropertyDefinition>

    @JsonIgnore
    fun `$getModelType`(): JavaType

}