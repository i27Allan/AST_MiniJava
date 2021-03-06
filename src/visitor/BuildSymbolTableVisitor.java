package visitor;

import symboltable.SymbolTable;
import ast.And;
import ast.ArrayAssign;
import ast.ArrayLength;
import ast.ArrayLookup;
import ast.Assign;
import ast.Block;
import ast.BooleanType;
import ast.Call;
import ast.ClassDeclExtends;
import ast.ClassDeclSimple;
import ast.False;
import ast.Formal;
import ast.Identifier;
import ast.IdentifierExp;
import ast.IdentifierType;
import ast.If;
import ast.IntArrayType;
import ast.IntegerLiteral;
import ast.IntegerType;
import ast.LessThan;
import ast.MainClass;
import ast.MethodDecl;
import ast.Minus;
import ast.NewArray;
import ast.NewObject;
import ast.Not;
import ast.Plus;
import ast.Print;
import ast.Program;
import ast.This;
import ast.Times;
import ast.True;
import ast.VarDecl;
import ast.While;
import symboltable.Class;
import symboltable.Method;

public class BuildSymbolTableVisitor implements Visitor {

	SymbolTable symbolTable;
	private Class currClass;
	private Method currMethod;

	public BuildSymbolTableVisitor() {
		this.symbolTable = new SymbolTable();
		this.currClass = null;
		this.currMethod = null;
	}

	public SymbolTable getSymbolTable() {
		return symbolTable;
	}

	public void setSymbolTable(SymbolTable symbolTable) {
		this.symbolTable = symbolTable;
	}

	public Class getCurrClass() {
		return currClass;
	}

	public void setCurrClass(Class currClass) {
		this.currClass = currClass;
	}

	public Method getCurrMethod() {
		return currMethod;
	}

	public void setCurrMethod(Method currMethod) {
		this.currMethod = currMethod;
	}

	// MainClass m;
	// ClassDeclList cl;
	public void visit(Program n) {
		n.m.accept(this);
		
		for (int x = 0; x < n.cl.size(); x++)	n.cl.elementAt(x).accept(this);
	}

	// Identifier i1,i2;
	// Statement s;
	public void visit(MainClass n) {
		this.currClass = new Class(n.i1.toString(), null);
		this.symbolTable.addClass(n.i1.toString(), null);

		n.i1.accept(this);
		n.i2.accept(this);
		n.s.accept(this);

		this.currClass = null;
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclSimple n) {
		this.currClass = new Class(n.i.s, null);
		this.symbolTable.addClass(n.i.s, null);
		
		n.i.accept(this);
		
		for (int x = 0; x < n.vl.size(); x++)	n.vl.elementAt(x).accept(this);
		
		for (int x = 0; x < n.ml.size(); x++)	n.ml.elementAt(x).accept(this);
		
		this.currClass = null;
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclExtends n) {
		this.currClass = new Class(n.i.s, n.j.s);
		this.symbolTable.addClass(n.i.s, n.j.s);

		n.i.accept(this);
		n.j.accept(this);
		
		for (int x = 0; x < n.vl.size(); x++)	n.vl.elementAt(x).accept(this);

		for (int x = 0; x < n.ml.size(); x++)	n.ml.elementAt(x).accept(this);

		this.currClass = null;
	}

	// Type t;
	// Identifier i;
	public void visit(VarDecl n) {
		if (currMethod == null)
			symbolTable.getClass(currClass.getId()).addVar(n.i.toString(), n.t);
		else
			symbolTable.getClass(currClass.getId()).getMethod(currMethod.getId()).addVar(n.i.toString(), n.t);

		n.t.accept(this);
		n.i.accept(this);
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
	public void visit(MethodDecl n) {
		this.currMethod = new Method(n.i.s, n.t);
		this.symbolTable.getClass(currClass.getId()).addMethod(n.i.s, n.t);

		n.t.accept(this);
		n.i.accept(this);
		
		for (int x = 0; x < n.fl.size(); x++)	n.fl.elementAt(x).accept(this);

		for (int x = 0; x < n.vl.size(); x++)	n.vl.elementAt(x).accept(this);

		for (int x = 0; x < n.sl.size(); x++)	n.sl.elementAt(x).accept(this);

		n.e.accept(this);

		this.currMethod = null;
	}

	// Type t;
	// Identifier i;
	public void visit(Formal n) {
		this.symbolTable.getClass(currClass.getId()).getMethod(currMethod.getId()).addParam(n.i.s, n.t);
		
		n.t.accept(this);
		n.i.accept(this);
	}

	public void visit(IntArrayType n) {
	}

	public void visit(BooleanType n) {
	}

	public void visit(IntegerType n) {
	}

	// String s;
	public void visit(IdentifierType n) {
	}

	// StatementList sl;
	public void visit(Block n) {
		for (int x = 0; x < n.sl.size(); x++)	n.sl.elementAt(x).accept(this);
	}

	// Exp e;
	// Statement s1,s2;
	public void visit(If n) {
		n.e.accept(this);
		n.s1.accept(this);
		n.s2.accept(this);
	}

	// Exp e;
	// Statement s;
	public void visit(While n) {
		n.e.accept(this);
		n.s.accept(this);
	}

	// Exp e;
	public void visit(Print n) {
		n.e.accept(this);
	}

	// Identifier i;
	// Exp e;
	public void visit(Assign n) {
		n.i.accept(this);
		n.e.accept(this);
	}

	// Identifier i;
	// Exp e1,e2;
	public void visit(ArrayAssign n) {
		n.i.accept(this);
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(And n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(LessThan n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(Plus n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(Minus n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(Times n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(ArrayLookup n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e;
	public void visit(ArrayLength n) {
		n.e.accept(this);
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public void visit(Call n) {
		n.e.accept(this);
		n.i.accept(this);
		
		for (int x = 0; x < n.el.size(); x++)	n.el.elementAt(x).accept(this);
	}

	// int i;
	public void visit(IntegerLiteral n) {
	}

	public void visit(True n) {
	}

	public void visit(False n) {
	}

	// String s;
	public void visit(IdentifierExp n) {
	}

	public void visit(This n) {
	}

	// Exp e;
	public void visit(NewArray n) {
		n.e.accept(this);
	}

	// Identifier i;
	public void visit(NewObject n) {
	}

	// Exp e;
	public void visit(Not n) {
		n.e.accept(this);
	}

	// String s;
	public void visit(Identifier n) {
	}
}