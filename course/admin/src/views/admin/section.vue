<template>
  <div>
    <p>
      <button v-on:click="add()" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-edit"></i>
        新增
      </button>
      &nbsp;
      <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-refresh"></i>
        刷新
      </button>
    </p>

    <pagination ref="pagination" v-bind:list="list" v-bind:itemCount="8"></pagination>

    <table id="simple-table" class="table  table-bordered table-hover">
      <thead>
      <tr>
        <th>id</th>
        <th>标题</th>
        <th>课程</th>
        <th>大章</th>
        <th>视频</th>
        <th>时长</th>
        <th>收费</th>
        <th>顺序</th>
        <th>vod</th>
        <th>操作</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="section in sections">
FreeMarker template error (DEBUG mode; use RETHROW in production!):
The following has evaluated to null or missing:
==> field.enums  [in template "vue.ftl" at line 33, column 18]

----
Tip: It's the step after the last dot that caused this error, not those before it.
----
Tip: If the failing expression is known to legally refer to something that's sometimes null or missing, either specify a default value like myOptionalVar!myDefault, or use <#if myOptionalVar??>when-present<#else>when-missing</#if>. (These only cover the last step of the expression; to cover the whole expression, use parenthesis: (myOptionalVar.foo)!myDefault, (myOptionalVar.foo)??
----

----
FTL stack trace ("~" means nesting-related):
	- Failed at: #if field.enums  [in template "vue.ftl" at line 33, column 13]
----

Java stack trace (for programmers):
----
freemarker.core.InvalidReferenceException: [... Exception message was already printed; see it above ...]
	at freemarker.core.InvalidReferenceException.getInstance(InvalidReferenceException.java:134)
	at freemarker.core.UnexpectedTypeException.newDescriptionBuilder(UnexpectedTypeException.java:85)
	at freemarker.core.UnexpectedTypeException.<init>(UnexpectedTypeException.java:48)
	at freemarker.core.NonBooleanException.<init>(NonBooleanException.java:47)
	at freemarker.core.Expression.modelToBoolean(Expression.java:195)
	at freemarker.core.Expression.evalToBoolean(Expression.java:178)
	at freemarker.core.Expression.evalToBoolean(Expression.java:163)
	at freemarker.core.IfBlock.accept(IfBlock.java:49)
	at freemarker.core.Environment.visit(Environment.java:334)
	at freemarker.core.Environment.visit(Environment.java:376)
	at freemarker.core.IteratorBlock$IterationContext.executedNestedContentForCollOrSeqListing(IteratorBlock.java:321)
	at freemarker.core.IteratorBlock$IterationContext.executeNestedContent(IteratorBlock.java:271)
	at freemarker.core.IteratorBlock$IterationContext.accept(IteratorBlock.java:244)
	at freemarker.core.Environment.visitIteratorBlock(Environment.java:644)
	at freemarker.core.IteratorBlock.acceptWithResult(IteratorBlock.java:108)
	at freemarker.core.IteratorBlock.accept(IteratorBlock.java:94)
	at freemarker.core.Environment.visit(Environment.java:334)
	at freemarker.core.Environment.visit(Environment.java:340)
	at freemarker.core.Environment.process(Environment.java:313)
	at freemarker.template.Template.process(Template.java:383)
	at com.course.generator.util.FreemarkerUtil.generator(FreemarkerUtil.java:33)
	at com.course.generator.vue.VueGenerator.main(VueGenerator.java:53)
