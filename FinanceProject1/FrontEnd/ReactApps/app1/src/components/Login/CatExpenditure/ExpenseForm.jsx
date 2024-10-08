import React, { useState } from 'react';
import axios from 'axios';


const categories = {
    "Bills and Utilities": ["Electricity Bill", "Gas Bill", "Internet Bills", "Phone Bills", "Television Bills", "Water Bill", "Loan / Credit Card", "Vehicle", "Others"],
    "Education": ["Stationary", "School/College Fees", "Uniform", "Others"],
    "Entertainment": ["Movies", "Games", "Streaming Services", "Others"],
    "Family": ["Home Maintenance", "Home Services", "Pets", "Others"],
    "Food": ["Restaurants", "Online-Delivery", "Others"],
    "Health": ["Gym", "Medical", "Others"],
    "House Rent/Loan Payments": ["Rent", "Loans", "Others"],
    "Shopping": ["Clothes", "Footwears", "Electronics", "Home Appliances", "Others"],
    "Child-care": ["Others"],
    "Insurance": ["Bike", "Car", "Health", "Others"],
    "Investment": ["Stocks/ETF/Mutual funds", "Term deposit", "Gold", "Bond", "Others"],
    "Others": ["Others"]
};


const ExpenseForm = ({ category, subcategory, onSubmit }) => {
    const [amount, setAmount] = useState('');
    const [date, setDate] = useState('');
    const [time, setTime] = useState('');
    const [location, setLocation] = useState('');
    const [description, setDescription] = useState('');
    const [transactionMode, setTransactionMode] = useState('');


    const handleSubmit = (e) => {
        e.preventDefault();
        const expenseData = {
            category,
            subCategory: subcategory,
            amount,
            date,
            time,
            location,
            description,
            transactionMode
        };
        onSubmit(expenseData);
    };


    return (
        <form onSubmit={handleSubmit} className="p-4 bg-light rounded shadow-sm">
            <div className="mb-3">
                <label className="form-label">Amount</label>
                <input type="number" className="form-control" value={amount} onChange={(e) => setAmount(e.target.value)} required />
            </div>
            <div className="mb-3">
                <label className="form-label">Date</label>
                <input type="date" className="form-control" value={date} onChange={(e) => setDate(e.target.value)} required />
            </div>
            <div className="mb-3">
                <label className="form-label">Time</label>
                <input type="time" className="form-control" value={time} onChange={(e) => setTime(e.target.value)} required />
            </div>
            <div className="mb-3">
                <label className="form-label">Location</label>
                <input type="text" className="form-control" value={location} onChange={(e) => setLocation(e.target.value)} required />
            </div>
            <div className="mb-3">
                <label className="form-label">Description</label>
                <textarea className="form-control" value={description} onChange={(e) => setDescription(e.target.value)} required></textarea>
            </div>
            <div className="mb-3">
                <label className="form-label">Mode of Transaction</label>
                <div>
                    <div className="form-check form-check-inline">
                        <input className="form-check-input" type="radio" name="transactionMode" id="cash" value="1" onChange={(e) => setTransactionMode(e.target.value)} required />
                        <label className="form-check-label" htmlFor="cash">Cash</label>
                    </div>
                    <div className="form-check form-check-inline">
                        <input className="form-check-input" type="radio" name="transactionMode" id="bank" value="2" onChange={(e) => setTransactionMode(e.target.value)} required />
                        <label className="form-check-label" htmlFor="bank">Bank (Online)</label>
                    </div>
                </div>
            </div>
            <button type="submit" className="btn btn-primary w-100">Submit</button>
        </form>
    );
};


const ExpensePage = () => {
    const [selectedCategory, setSelectedCategory] = useState(null);
    const [selectedSubcategory, setSelectedSubcategory] = useState(null);


    const handleCategoryClick = (category) => {
        setSelectedCategory(category);
        setSelectedSubcategory(null);
    };


    const handleSubcategoryClick = (subcategory) => {
        setSelectedSubcategory(subcategory);
    };


    const handleSubmit = (expenseData) => {
        axios.post('http://localhost:8080/api/expenditures', expenseData)
            .then(response => {
                console.log('Expense submitted successfully', response.data);
            })
            .catch(error => {
                console.error('There was an error submitting the expense!', error);
            });
    };


    return (
        <div className="container mt-5">
            <h1 className="text-center mb-4">Add Expenditure</h1>
            <div className="d-flex justify-content-center mb-3">
                <div className="dropdown">
                    <button className="btn btn-primary dropdown-toggle" type="button" id="categoryDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        {selectedCategory ? selectedCategory : 'Select Category'}
                    </button>
                    <ul className="dropdown-menu" aria-labelledby="categoryDropdown">
                        {Object.keys(categories).map(category => (
                            <li key={category}>
                                <a className="dropdown-item" href="#!" onClick={() => handleCategoryClick(category)}>
                                    {category}
                                </a>
                            </li>
                        ))}
                    </ul>
                </div>
            </div>
            {selectedCategory && (
                <div className="d-flex justify-content-center mb-3">
                    <div className="dropdown">
                        <button className="btn btn-primary dropdown-toggle" type="button" id="subcategoryDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                            {selectedSubcategory ? selectedSubcategory : 'Select Subcategory'}
                        </button>
                        <ul className="dropdown-menu" aria-labelledby="subcategoryDropdown">
                            {categories[selectedCategory].map(subcategory => (
                                <li key={subcategory}>
                                    <a className="dropdown-item" href="#!" onClick={() => handleSubcategoryClick(subcategory)}>
                                        {subcategory}
                                    </a>
                                </li>
                            ))}
                        </ul>
                    </div>
                </div>
            )}
            {selectedSubcategory && (
                <div className="d-flex justify-content-center">
                    <div className="w-50">
                        <h3 className="text-center">{selectedSubcategory}</h3>
                        <ExpenseForm category={selectedCategory} subcategory={selectedSubcategory} onSubmit={handleSubmit} />
                    </div>
                </div>
            )}
        </div>
    );
};


export default ExpensePage;

