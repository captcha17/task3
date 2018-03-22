<form method="post" action="/" name="estateFrom" id="estateForm">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="street">Street</label>
            <input type="text" name="street" class="form-control" id="street" placeholder="Lenina st.">
        </div>
        <div class="form-group col-md-4">
            <label for="floors">Floors</label>
            <select id="floors" name="floors" class="form-control">
                <option>1</option>
                <option>2</option>
                <option>3</option>
            </select>
        </div>
        <div class="form-group col-md-4">
            <label for="rooms">Rooms</label>
            <select id="rooms" name="rooms" class="form-control">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="price">Price</label>
        <input type="number" name="price" class="form-control currency" id="price" placeholder="100000">
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>