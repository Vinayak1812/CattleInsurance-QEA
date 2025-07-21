import React, { useState, useEffect } from 'react';
import './AdminDashboard.css';

const JuniorAdminDashboard = ({ onLogout, user }) => {
  const [pendingPolicies, setPendingPolicies] = useState([]);
  const [loading, setLoading] = useState(true);
  const [selectedPolicy, setSelectedPolicy] = useState(null);
  const [comments, setComments] = useState('');
  const [showModal, setShowModal] = useState(false);

  useEffect(() => {
    fetchPendingPolicies();
  }, []);

  const fetchPendingPolicies = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/policies/pending-junior');
      const data = await response.json();
      setPendingPolicies(data);
    } catch (error) {
      console.error('Error fetching pending policies:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleApprove = async () => {
    if (!selectedPolicy || !comments.trim()) {
      alert('Please provide comments before approving');
      return;
    }

    try {
      const response = await fetch(`http://localhost:8080/api/policies/${selectedPolicy.applicationId}/junior-approve`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          adminId: user.userId,
          comments: comments
        }),
      });

      const data = await response.json();
      if (data.success) {
        alert('Policy approved successfully!');
        setShowModal(false);
        setSelectedPolicy(null);
        setComments('');
        fetchPendingPolicies();
      }
    } catch (error) {
      console.error('Error approving policy:', error);
      alert('Error approving policy');
    }
  };

  const handleReject = async () => {
    if (!selectedPolicy || !comments.trim()) {
      alert('Please provide comments before rejecting');
      return;
    }

    try {
      const response = await fetch(`http://localhost:8080/api/policies/${selectedPolicy.applicationId}/junior-reject`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          adminId: user.userId,
          comments: comments
        }),
      });

      const data = await response.json();
      if (data.success) {
        alert('Policy rejected successfully!');
        setShowModal(false);
        setSelectedPolicy(null);
        setComments('');
        fetchPendingPolicies();
      }
    } catch (error) {
      console.error('Error rejecting policy:', error);
      alert('Error rejecting policy');
    }
  };

  const openModal = (policy) => {
    setSelectedPolicy(policy);
    setShowModal(true);
  };

  const closeModal = () => {
    setShowModal(false);
    setSelectedPolicy(null);
    setComments('');
  };

  if (loading) {
    return <div className="admin-dashboard">Loading...</div>;
  }

  return (
    <div className="admin-dashboard">
      <header className="admin-header">
        <h1>Junior Admin Dashboard</h1>
        <div className="admin-info">
          <span>Welcome, {user?.username}</span>
          <button onClick={onLogout} className="logout-btn">Logout</button>
        </div>
      </header>

      <main className="admin-main">
        <div className="dashboard-stats">
          <div className="stat-card">
            <h3>Pending Applications</h3>
            <p className="stat-number">{pendingPolicies.length}</p>
          </div>
        </div>

        <div className="policies-section">
          <h2>Pending Policy Applications</h2>
          {pendingPolicies.length === 0 ? (
            <p className="no-policies">No pending applications</p>
          ) : (
            <div className="policies-grid">
              {pendingPolicies.map((policy) => (
                <div key={policy.applicationId} className="policy-card">
                  <h3>Application #{policy.applicationId}</h3>
                  <div className="policy-details">
                    <p><strong>User ID:</strong> {policy.userId}</p>
                    <p><strong>Policy ID:</strong> {policy.policyId}</p>
                    <p><strong>Cattle ID:</strong> {policy.cattleId}</p>
                    <p><strong>Premium Amount:</strong> ₹{policy.premiumAmount}</p>
                    <p><strong>Coverage Amount:</strong> ₹{policy.coverageAmount}</p>
                    <p><strong>Created:</strong> {new Date(policy.createdAt).toLocaleDateString()}</p>
                  </div>
                  <div className="policy-actions">
                    <button 
                      onClick={() => openModal(policy)}
                      className="review-btn"
                    >
                      Review Application
                    </button>
                  </div>
                </div>
              ))}
            </div>
          )}
        </div>
      </main>

      {/* Review Modal */}
      {showModal && (
        <div className="modal-overlay">
          <div className="modal">
            <div className="modal-header">
              <h2>Review Application #{selectedPolicy.applicationId}</h2>
              <button onClick={closeModal} className="close-btn">&times;</button>
            </div>
            <div className="modal-body">
              <div className="policy-review-details">
                <h3>Application Details</h3>
                <p><strong>User ID:</strong> {selectedPolicy.userId}</p>
                <p><strong>Policy ID:</strong> {selectedPolicy.policyId}</p>
                <p><strong>Cattle ID:</strong> {selectedPolicy.cattleId}</p>
                <p><strong>Premium Amount:</strong> ₹{selectedPolicy.premiumAmount}</p>
                <p><strong>Coverage Amount:</strong> ₹{selectedPolicy.coverageAmount}</p>
                <p><strong>Created:</strong> {new Date(selectedPolicy.createdAt).toLocaleDateString()}</p>
              </div>
              
              <div className="comments-section">
                <label htmlFor="comments">Comments:</label>
                <textarea
                  id="comments"
                  value={comments}
                  onChange={(e) => setComments(e.target.value)}
                  placeholder="Enter your review comments..."
                  rows="4"
                />
              </div>
            </div>
            <div className="modal-footer">
              <button onClick={closeModal} className="cancel-btn">Cancel</button>
              <button onClick={handleReject} className="reject-btn">Reject</button>
              <button onClick={handleApprove} className="approve-btn">Approve</button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default JuniorAdminDashboard; 