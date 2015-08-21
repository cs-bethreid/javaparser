package me.tomassetti.symbolsolver.model.reflection;

import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import me.tomassetti.symbolsolver.JavaParserFacade;
import me.tomassetti.symbolsolver.javaparser.Navigator;
import me.tomassetti.symbolsolver.model.AbstractTest;
import me.tomassetti.symbolsolver.model.Context;
import me.tomassetti.symbolsolver.model.SymbolReference;
import me.tomassetti.symbolsolver.model.TypeSolver;
import me.tomassetti.symbolsolver.model.declarations.ClassDeclaration;
import me.tomassetti.symbolsolver.model.declarations.FieldDeclaration;
import me.tomassetti.symbolsolver.model.declarations.ValueDeclaration;
import me.tomassetti.symbolsolver.model.javaparser.contexts.EnumDeclarationContext;
import me.tomassetti.symbolsolver.model.typesolvers.DummyTypeSolver;
import me.tomassetti.symbolsolver.model.typesolvers.JreTypeSolver;
import me.tomassetti.symbolsolver.model.usages.TypeUsage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by federico on 21/08/15.
 */
public class SymbolResolutionTest extends AbstractTest {

    /*@Test
    public void getTypeOfField() throws ParseException {
        CompilationUnit cu = parseSample("ReflectionFieldOfItself");
        ClassOrInterfaceDeclaration clazz = Navigator.demandClass(cu, "MyClass");
        VariableDeclarator field = Navigator.demandField(clazz, "PUBLIC");

        TypeSolver typeSolver = new JreTypeSolver();
        TypeUsage ref = JavaParserFacade.get(typeSolver).getType(field);
        assertEquals("int", ref.getTypeName());
    }*/

    @Test
    public void getTypeOfFieldAccess() throws ParseException {
        CompilationUnit cu = parseSample("ReflectionFieldOfItself");
        ClassOrInterfaceDeclaration clazz = Navigator.demandClass(cu, "MyClass");
        VariableDeclarator field = Navigator.demandField(clazz, "PUBLIC");

        TypeSolver typeSolver = new JreTypeSolver();
        TypeUsage ref = JavaParserFacade.get(typeSolver).getType(field.getInit());
        assertEquals("int", ref.getTypeName());
    }

}
