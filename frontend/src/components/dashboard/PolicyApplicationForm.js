import React, { useState } from 'react';
import './PolicyApplicationForm.css';

const PolicyApplicationForm = ({ onClose, onSuccess }) => {
  const [formData, setFormData] = useState({
    policyId: '',
    cattleId: '',
    premiumAmount: '',
    coverageAmount: ''
  });
  const [loading, setLoading] = useState(false);
  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
    // Clear error when user starts typing
    if (errors[name]) {
      setErrors(prev => ({
        ...prev,
        [name]: ''
      }));
    }
  };

  const validateForm = () => {
    const newErrors = {};
    
    if (!formData.policyId) {
      newErrors.policyId = 'Policy ID is required';
    }
    
    if (!formData.cattleId) {
      newErrors.cattleId = 'Cattle ID is required';
    }
    
    if (!formData.premiumAmount) {
      newErrors.premiumAmount = 'Premium amount is required';
    } else if (isNaN(formData.premiumAmount) || parseFloat(formData.premiumAmount) <= 0) {
      newErrors.premiumAmount = 'Premium amount must be a positive number';
    }
    
    if (!formData.coverageAmount) {
      newErrors.coverageAmount = 'Coverage amount is required';
    } else if (isNaN(formData.coverageAmount) || parseFloat(formData.coverageAmount) <= 0) {
      newErrors.coverageAmount = 'Coverage amount must be a positive number';
    }
    
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    if (!validateForm()) {
      return;
    }
    
    setLoading(true);
    
    try {
      const user = JSON.parse(localStorage.getItem('user'));
      
      const response = await fetch('http://localhost:8080/api/policies/apply', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          ...formData,
          userId: user.userId,
          premiumAmount: parseFloat(formData.premiumAmount),
          coverageAmount: parseFloat(formData.coverageAmount)
        }),
      });
      
      const data = await response.json();
      
      if (data.success) {
        alert(`Policy application submitted successfully! Application ID: ${data.applicationId}`);
        if (onSuccess) {
          onSuccess();
        }
        onClose();
      } else {
        setErrors({ general: data.message || 'Failed to submit application' });
      }
    } catch (error) {
      console.error('Error submitting policy application:', error);
      setErrors({ general: 'Error submitting application. Please try again.' });
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="policy-form-overlay">
      <div className="policy-form-modal">
        <div className="policy-form-header">
          <h2>Apply for Cattle Insurance Policy</h2>
          <button onClick={onClose} className="close-btn">&times;</button>
        </div>
        
        <form onSubmit={handleSubmit} className="policy-form">
          {errors.general && (
            <div className="error-message general-error">
              {errors.general}
            </div>
          )}
          
          <div className="form-group">
            <label htmlFor="policyId">Policy ID *</label>
            <input
              type="number"
              id="policyId"
              name="policyId"
              value={formData.policyId}
              onChange={handleChange}
              className={errors.policyId ? 'error' : ''}
              placeholder="Enter policy ID"
              disabled={loading}
            />
            {errors.policyId && <span className="error-text">{errors.policyId}</span>}
          </div>
          
          <div className="form-group">
            <label htmlFor="cattleId">Cattle ID *</label>
            <input
              type="text"
              id="cattleId"
              name="cattleId"
              value={formData.cattleId}
              onChange={handleChange}
              className={errors.cattleId ? 'error' : ''}
              placeholder="Enter cattle ID"
              disabled={loading}
            />
            {errors.cattleId && <span className="error-text">{errors.cattleId}</span>}
          </div>
          
          <div className="form-group">
            <label htmlFor="premiumAmount">Premium Amount (₹) *</label>
            <input
              type="number"
              id="premiumAmount"
              name="premiumAmount"
              value={formData.premiumAmount}
              onChange={handleChange}
              className={errors.premiumAmount ? 'error' : ''}
              placeholder="Enter premium amount"
              disabled={loading}
              step="0.01"
            />
            {errors.premiumAmount && <span className="error-text">{errors.premiumAmount}</span>}
          </div>
          
          <div className="form-group">
            <label htmlFor="coverageAmount">Coverage Amount (₹) *</label>
            <input
              type="number"
              id="coverageAmount"
              name="coverageAmount"
              value={formData.coverageAmount}
              onChange={handleChange}
              className={errors.coverageAmount ? 'error' : ''}
              placeholder="Enter coverage amount"
              disabled={loading}
              step="0.01"
            />
            {errors.coverageAmount && <span className="error-text">{errors.coverageAmount}</span>}
          </div>
          
          <div className="form-actions">
            <button 
              type="button" 
              onClick={onClose} 
              className="cancel-btn"
              disabled={loading}
            >
              Cancel
            </button>
            <button 
              type="submit" 
              className={`submit-btn ${loading ? 'loading' : ''}`}
              disabled={loading}
            >
              {loading ? 'Submitting...' : 'Submit Application'}
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default PolicyApplicationForm; 