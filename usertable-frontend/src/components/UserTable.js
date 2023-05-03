import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const DataTable = () => {
  const [data, setData] = useState([]);
  const [searchText, setSearchText] = useState('');
  const [pageSize, setPageSize] = useState(10);
  const [currentPage, setCurrentPage] = useState(1);
  const [sortColumn, setSortColumn] = useState(null);
  const [sortOrder, setSortOrder] = useState('asc');

  useEffect(() => {
     fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await fetch('http://localhost:9001/api/v1/users');

      const jsonData = await response.json();
       // console.log(jsonData)
      setData(jsonData);
    } catch (error) {
      console.error(error);
    }
  };

    


  const filteredData = data.filter((item) =>
    item.name.toLowerCase().includes(searchText.toLowerCase())
  );

  const sortedData = filteredData.slice().sort((a, b) => {
    if (sortColumn && sortOrder === 'asc') {
      return a[sortColumn].localeCompare(b[sortColumn]);
    } else if (sortColumn && sortOrder === 'desc') {
      return b[sortColumn].localeCompare(a[sortColumn]);
    }
    return 0;
  });

  const totalPages = Math.ceil(sortedData.length / pageSize);

  const paginatedData = sortedData.slice(
    (currentPage - 1) * pageSize,
    currentPage * pageSize
  );

  const handleSort = (column) => {
    if (sortColumn === column) {
      setSortOrder(sortOrder === 'asc' ? 'desc' : 'asc');
    } else {
      setSortColumn(column);
      setSortOrder('asc');
    }
  };

  return (
    <div className="container">
      <div className="row">
        
        <div className="col-6 ">
          <select
            value={pageSize}
            onChange={(e) => setPageSize(Number(e.target.value))}
          >
            <option value="10">10 rows</option>
            <option value="20">20 rows</option>
            <option value="30">30 rows</option>
          </select>
        </div>
        <div className="col-6 d-flex justify-content-end">
          <input
            type="text"
            placeholder="Search"
            value={searchText}
            onChange={(e) => setSearchText(e.target.value)}
          />
        </div>
      </div>
      <table className="table">
        <thead>
          <tr>
            <th onClick={() => handleSort('name')}>Name</th>
            <th onClick={() => handleSort('position')}>Position</th>
            <th onClick={() => handleSort('office')}>Office</th>
            <th onClick={() => handleSort('age')}>Age</th>
            <th onClick={() => handleSort('startDate')}>Start Date</th>
            <th onClick={() => handleSort('salary')}>Salary</th>
          </tr>
        </thead>
        <tbody>
          {paginatedData.map((item) => (
            <tr key={item.id}>
              <td>{item.name}</td>
              <td>{item.position}</td>
              <td>{item.office}</td>
              <td>{item.age}</td>
              <td>{item.startDate}</td>
              <td>{item.salary}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <div className="row">
        <div className="col-lg-6">
          Showing {paginatedData.length} out of {filteredData.lfength} entries
        </div>
        <div className="col-lg-6 d-flex justify-content-end">
          <div>
            Page {currentPage} of {totalPages}
          </div>
          <div>
            <button
              className="btn btn-primary mx-2"
              disabled={currentPage === 1}
              onClick={() => setCurrentPage((prevPage) => prevPage - 1)}
            >
              Previous
            </button>
            <button
              className="btn btn-primary"
              disabled={currentPage === totalPages}
              onClick={() => setCurrentPage((prevPage) => prevPage + 1)}
            >
              Next
            </button>
          </div>
        </div>
      </div>
    </div>
  );
  };



const App = () => {
  return (
    <div>
      <DataTable />
    </div>
  );
};

export default App;
