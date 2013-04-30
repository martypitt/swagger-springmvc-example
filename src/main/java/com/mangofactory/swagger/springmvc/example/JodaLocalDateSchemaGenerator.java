package com.mangofactory.swagger.springmvc.example;

import com.fasterxml.classmate.ResolvedType;
import com.google.common.base.Function;
import com.mangofactory.swagger.models.CustomSchemaGenerator;
import com.mangofactory.swagger.models.MemberInfoSource;
import com.mangofactory.swagger.models.MemberVisitor;
import com.mangofactory.swagger.models.SchemaProvider;
import com.wordnik.swagger.core.DocumentationSchema;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class JodaLocalDateSchemaGenerator implements CustomSchemaGenerator {
    @Override
    public boolean supports(ResolvedType type) {
        return LocalDate.class.equals(type.getErasedType());
    }

    @Override
    public Function<SchemaProvider, MemberVisitor> factory() {
        return new Function<SchemaProvider, MemberVisitor>() {
            @Override
            public MemberVisitor apply(final SchemaProvider schemaProvider) {
                return new MemberVisitor() {
                    @Override
                    public DocumentationSchema schema(MemberInfoSource property) {
                        DocumentationSchema schema = new DocumentationSchema();
                        schema.setName(property.getName());
                        schema.setType("date");
                        schema.setDefault(LocalDate.now().toString());
                        schema.setNotes("LocalDate type");
                        if (!schemaProvider.getSchemaMap().containsKey(property.getName())) {
                            schemaProvider.getSchemaMap().put(property.getName(), schema);
                        }
                        return schema;
                    }
                };
            }
        };
    }
}
