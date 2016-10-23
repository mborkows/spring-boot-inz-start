<!DOCTYPE html>

<html lang="en">

<body>
<table>
    <thead>
    <tr>
        <td>Title</td>
        <td>Body</td>
        <td>Tags</td>
    </tr>
    </thead>
    <tbody>
    <#list notes as note>
    <tr>
        <td>${note.title}</td>
        <td>${note.body}</td>
        <#if note.tags??>
            <td>
                <#list note.tags as tag>
                    <span>${tag.name}</span>
                </#list>
            </td>
        </#if>

    </tr>
    </#list>
    </tbody>
</table>
</body>

</html>
