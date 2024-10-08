import React, { useState } from 'react';
import axios from 'axios';

const IncomePage = () => {
    const [category, setCategory] = useState('');
    const [formData, setFormData] = useState({
        incomeId: 'hidden', // Hidden incomeId
        incomeAmount: '',
        description: '',
        modeOfPayment: 'online', // Default to 'online'
        date: '',
        time: '',
    });

    const handleCategoryChange = (e) => {
        setCategory(e.target.value);
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api', formData)
            .then(response => {
                console.log('Data submitted successfully:', response.data);
            })
            .catch(error => {
                console.error('There was an error submitting the data:', error);
            });
    };

    return (
        <div className="container mt-5">
            <h1 className="text-center">Income Page</h1>
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <div className="form-group">
                        <label htmlFor="incomeCategory">Source of Income</label>
                        <select
                            id="incomeCategory"
                            className="form-control"
                            value={category}
                            onChange={handleCategoryChange}
                        >
                            <option value="">Select Category</option>
                            <option value="Salary">Salary</option>
                            <option value="Loan/Borrowing">Loan/Borrowing</option>
                            <option value="Investment">Investment</option>
                        </select>
                    </div>

                    {category && (
                        <form onSubmit={handleSubmit}>
                            <div className="form-group">
                                <label htmlFor="incomeAmount">Income Amount</label>
                                <input
                                    type="number"
                                    className="form-control"
                                    id="incomeAmount"
                                    name="incomeAmount"
                                    value={formData.incomeAmount}
                                    onChange={handleInputChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="description">Description</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="description"
                                    name="description"
                                    value={formData.description}
                                    onChange={handleInputChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label>Mode of Payment</label>
                                <div>
                                    <div className="form-check form-check-inline">
                                        <input
                                            className="form-check-input"
                                            type="radio"
                                            id="online"
                                            name="modeOfPayment"
                                            value="online"
                                            checked={formData.modeOfPayment === 'online'}
                                            onChange={handleInputChange}
                                        />
                                        <label className="form-check-label" htmlFor="online">Online</label>
                                    </div>
                                    <div className="form-check form-check-inline">
                                        <input
                                            className="form-check-input"
                                            type="radio"
                                            id="cash"
                                            name="modeOfPayment"
                                            value="cash"
                                            checked={formData.modeOfPayment === 'cash'}
                                            onChange={handleInputChange}
                                        />
                                        <label className="form-check-label" htmlFor="cash">Cash</label>
                                    </div>
                                </div>
                            </div>
                            <div className="form-group">
                                <label htmlFor="date">Date</label>
                                <input
                                    type="date"
                                    className="form-control"
                                    id="date"
                                    name="date"
                                    value={formData.date}
                                    onChange={handleInputChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="time">Time</label>
                                <input
                                    type="time"
                                    className="form-control"
                                    id="time"
                                    name="time"
                                    value={formData.time}
                                    onChange={handleInputChange}
                                    required
                                />
                            </div>
                            <button type="submit" className="btn btn-primary btn-block">Submit</button>
                        </form>
                    )}
                </div>
            </div>
        </div>
    );
};

export default IncomePage;
