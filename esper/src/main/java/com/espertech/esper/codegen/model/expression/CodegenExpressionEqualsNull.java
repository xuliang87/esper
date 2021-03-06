/*
 ***************************************************************************************
 *  Copyright (C) 2006 EsperTech, Inc. All rights reserved.                            *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 ***************************************************************************************
 */
package com.espertech.esper.codegen.model.expression;

import java.util.Map;
import java.util.Set;

public class CodegenExpressionEqualsNull implements CodegenExpression {
    private final CodegenExpression lhs;
    private final boolean not;

    public CodegenExpressionEqualsNull(CodegenExpression lhs, boolean not) {
        this.lhs = lhs;
        this.not = not;
    }

    public void render(StringBuilder builder, Map<Class, String> imports, boolean isInnerClass) {
        lhs.render(builder, imports, isInnerClass);
        builder.append(" ");
        builder.append(not ? "!=" : "==");
        builder.append(" null");
    }

    public void mergeClasses(Set<Class> classes) {
        lhs.mergeClasses(classes);
    }
}
