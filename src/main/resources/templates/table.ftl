<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Street</th>
        <th scope="col">Number of floors</th>
        <th scope="col">Number of rooms</th>
        <th scope="col">Price $</th>
        <th scope="col">Views</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <#if estates??>
        <#list estates as estate>
            <tr>
                <td scope="row">${estate.street}</td>
                <td>${estate.floors}</td>
                <td>${estate.rooms}</td>
                <td>${estate.price}</td>
                <td id="view${estate.id}">${estate.views}</td>
                <td><a class="link" href="#" onclick="increaseCount(${estate.id})">View</a></td>
                <td></td>
            </tr>
        </#list>
    </#if>
    </tbody>
</table>