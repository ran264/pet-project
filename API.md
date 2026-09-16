1. Lấy danh sách thú cưng
   GET /api/v1/pets
   Parameter: null
   Body: null

2. Xem thú cưng theo ID
   GET /api/v1/pets/{id}
   Parameter: id
   Body: null

3. Thêm thú cưng
   POST /api/v1/pets
   Parameter: null
   Body:
   {
   "name": "Milu",
   "age": 2
   }

4. Cập nhật thú cưng
   PUT /api/v1/pets/{id}
   Parameter: id
   Body:
   {
   "name": "Milu",
   "age": 3
   }

5. Xóa thú cưng
   DELETE /api/v1/pets/{id}
   Parameter: id
   Body: null