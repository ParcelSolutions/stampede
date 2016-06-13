/*
 *     This file is part of ToroDB.
 *
 *     ToroDB is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ToroDB is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with ToroDB. If not, see <http://www.gnu.org/licenses/>.
 *
 *     Copyright (c) 2014, 8Kdata Technology
 *     
 */

package com.torodb.backend.converters.jooq;

import java.util.Collection;
import java.util.List;

import org.jooq.Binding;
import org.jooq.Configuration;
import org.jooq.Converter;
import org.jooq.DataType;
import org.jooq.EnumType;
import org.jooq.Field;
import org.jooq.SQLDialect;

import com.torodb.kvdocument.values.KVValue;

/**
 *
 */
public class DataTypeForKV<T extends KVValue<?>> implements DataType<T> {
    
    private static final long serialVersionUID = 1L;
    
    public static <DT, T extends KVValue<?>> DataTypeForKV<T> from(DataType<DT> dataType, KVValueConverter<DT, T> converter) {
        return new DataTypeForKV<>(dataType.asConvertedDataType(converter), converter);
    }
    
    public static <DT, T extends KVValue<?>> DataTypeForKV<T> from(DataType<DT> dataType, KVValueConverter<DT, T> converter, Binding<DT, T> binding) {
        return new DataTypeForKV<>(dataType.asConvertedDataType(binding), converter);
    }
    
    private final DataType<T> dataType;
    private final KVValueConverter<?, T> kvValueConverter;
    
    private DataTypeForKV(DataType<T> dataType, KVValueConverter<?, T> kvValueConverter) {
        super();
        this.dataType = dataType;
        this.kvValueConverter = kvValueConverter;
    }

    public KVValueConverter<?, T> getKVValueConverter() {
        return kvValueConverter;
    }
    
    public DataType<T> getSQLDataType() {
        return dataType.getSQLDataType();
    }

    public DataType<T> getDataType(Configuration configuration) {
        return dataType.getDataType(configuration);
    }

    public int getSQLType() {
        return dataType.getSQLType();
    }

    public Binding<?, T> getBinding() {
        return dataType.getBinding();
    }

    public Converter<?, T> getConverter() {
        return dataType.getConverter();
    }

    public Class<T> getType() {
        return dataType.getType();
    }

    public Class<T[]> getArrayType() {
        return dataType.getArrayType();
    }

    public DataType<T[]> getArrayDataType() {
        return dataType.getArrayDataType();
    }

    public <E extends EnumType> DataType<E> asEnumDataType(Class<E> enumDataType) {
        return new DataTypeForKV(dataType.asEnumDataType(enumDataType), kvValueConverter);
    }

    public <U> DataType<U> asConvertedDataType(Converter<? super T, U> converter) {
        return new DataTypeForKV(dataType.asConvertedDataType(converter), kvValueConverter);
    }

    public <U> DataType<U> asConvertedDataType(Binding<? super T, U> binding) {
        return new DataTypeForKV(dataType.asConvertedDataType(binding), kvValueConverter);
    }

    public String getTypeName() {
        return dataType.getTypeName();
    }

    public String getTypeName(Configuration configuration) {
        return dataType.getTypeName(configuration);
    }

    public String getCastTypeName() {
        return dataType.getCastTypeName();
    }

    public String getCastTypeName(Configuration configuration) {
        return dataType.getCastTypeName(configuration);
    }

    public SQLDialect getDialect() {
        return dataType.getDialect();
    }

    public T convert(Object object) {
        return dataType.convert(object);
    }

    public T[] convert(Object... objects) {
        return dataType.convert(objects);
    }

    public List<T> convert(Collection<?> objects) {
        return dataType.convert(objects);
    }

    public DataType<T> nullable(boolean nullable) {
        return new DataTypeForKV(dataType.nullable(nullable), kvValueConverter);
    }

    public boolean nullable() {
        return dataType.nullable();
    }

    @Deprecated
    public DataType<T> defaulted(boolean defaulted) {
        return dataType.defaulted(defaulted);
    }

    public boolean defaulted() {
        return dataType.defaulted();
    }

    public DataType<T> precision(int precision) {
        return new DataTypeForKV(dataType.precision(precision), kvValueConverter);
    }

    public DataType<T> precision(int precision, int scale) {
        return new DataTypeForKV(dataType.precision(precision, scale), kvValueConverter);
    }

    public int precision() {
        return dataType.precision();
    }

    public boolean hasPrecision() {
        return dataType.hasPrecision();
    }

    public DataType<T> scale(int scale) {
        return new DataTypeForKV(dataType.scale(scale), kvValueConverter);
    }

    public int scale() {
        return dataType.scale();
    }

    public boolean hasScale() {
        return dataType.hasScale();
    }

    public DataType<T> length(int length) {
        return new DataTypeForKV(dataType.length(length), kvValueConverter);
    }

    public int length() {
        return dataType.length();
    }

    public boolean hasLength() {
        return dataType.hasLength();
    }

    public boolean isNumeric() {
        return dataType.isNumeric();
    }

    public boolean isString() {
        return dataType.isString();
    }

    public boolean isDateTime() {
        return dataType.isDateTime();
    }

    public boolean isTemporal() {
        return dataType.isTemporal();
    }

    public boolean isInterval() {
        return dataType.isInterval();
    }

    public boolean isBinary() {
        return dataType.isBinary();
    }

    public boolean isLob() {
        return dataType.isLob();
    }

    public boolean isArray() {
        return dataType.isArray();
    }

    @Override
    public DataType<T> defaultValue(T defaultValue) {
        return new DataTypeForKV(dataType.defaultValue(defaultValue), kvValueConverter);
    }

    @Override
    public DataType<T> defaultValue(Field<T> defaultValue) {
        return new DataTypeForKV(dataType.defaultValue(defaultValue), kvValueConverter);
    }

    @Override
    public Field<T> defaultValue() {
        return dataType.defaultValue();
    }
}