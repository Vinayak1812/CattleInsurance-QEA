# Cattle Insurance Management System

A comprehensive cattle insurance management system with role-based access control for farmers, junior admins, and senior admins.

## Features

### 🔐 Authentication System
- **Farmer Login**: Regular user authentication
- **Junior Admin Login**: Username: `juniorAdmin`, Password: `Junior@12345`
- **Senior Admin Login**: Username: `seniorAdmin`, Password: `Senior@12345`

### 👨‍🌾 Farmer Dashboard
- View insurance policies
- Manage cattle information
- Apply for new insurance policies
- File claims
- View notifications

### 👨‍💼 Junior Admin Dashboard
- Review pending policy applications
- Approve or reject applications with comments
- View application details
- Track application status

### 👨‍💻 Senior Admin Dashboard
- Review applications approved by Junior Admin
- Final approval or rejection with comments
- Assign application numbers to approved policies
- Complete workflow management

## Workflow

1. **Farmer Registration & Policy Application**
   - Farmer registers and logs in
   - Submits policy application for their cattle
   - Application goes to "PENDING" status

2. **Junior Admin Review**
   - Junior Admin reviews pending applications
   - Can approve (moves to "JUNIOR_APPROVED") or reject (moves to "REJECTED")
   - Must provide comments for decisions

3. **Senior Admin Final Review**
   - Senior Admin reviews Junior Admin approved applications
   - Can approve (moves to "APPROVED") or reject (moves to "REJECTED")
   - Approved applications get application numbers assigned

## Technology Stack

### Frontend
- **React 19.1.0** - Modern React with hooks
- **React Router DOM** - Client-side routing
- **Axios** - HTTP client for API calls
- **CSS3** - Modern styling with gradients and animations

### Backend
- **Spring Boot** - Java-based REST API
- **Spring Data JPA** - Database operations
- **H2 Database** - In-memory database (can be changed to MySQL/PostgreSQL)
- **Maven** - Dependency management

## Database Schema

### Core Entities
- **User Role**: role_id, name (Farmer, Junior Admin, Senior Admin)
- **User**: user_id, role_id, username, address_id, contact_no, email, password_hash, cattle_id, gender
- **Address**: address_id, address_street, address_city, address_pin_code, address_state, region_id
- **Region**: region_id, region_name, description
- **Cattle**: cattle_tag, user_id, cattle_type, breed, policy_id, birth_date, gender
- **Policy Main**: policy_id, policy_name, description, premium_amount, coverage_amount, duration_months
- **Policy**: application_id, user_id, status_id, junior_admin_id, senior_admin_id, policy_id, cattle_id, premium_amount, coverage_amount, comments, created_at, updated_at
- **Status**: status_id, status_name
- **Action**: action_id, action_name
- **Audit Logs**: log_id, application_id, action_by, action_id, role_id, timestamp, details
- **Document**: document_id, document_name, application_id, file_path, file_type, file_size, upload_date

## Getting Started

### Prerequisites
- Node.js (v16 or higher)
- Java 17 or higher
- Maven 3.6 or higher

### Frontend Setup
```bash
cd frontend
npm install
npm start
```

The React app will run on `http://localhost:3000`

### Backend Setup
```bash
cd backend/CattleInsurance
mvn spring-boot:run
```

The Spring Boot API will run on `http://localhost:8080`

## API Endpoints

### Authentication
- `POST /api/auth/login` - User login

### Policy Management
- `GET /api/policies/pending-junior` - Get pending applications for Junior Admin
- `GET /api/policies/pending-senior` - Get pending applications for Senior Admin
- `POST /api/policies/apply` - Submit new policy application
- `POST /api/policies/{id}/junior-approve` - Junior Admin approval
- `POST /api/policies/{id}/junior-reject` - Junior Admin rejection
- `POST /api/policies/{id}/senior-approve` - Senior Admin approval
- `POST /api/policies/{id}/senior-reject` - Senior Admin rejection

## Usage Instructions

### For Farmers
1. Login with your credentials
2. Navigate to "Apply for Policy" in the dashboard
3. Fill in the required information:
   - Policy ID
   - Cattle ID
   - Premium Amount
   - Coverage Amount
4. Submit the application
5. Track your application status

### For Junior Admins
1. Login with username: `juniorAdmin`, password: `Junior@12345`
2. View pending applications in the dashboard
3. Click "Review Application" for any application
4. Add comments and approve or reject
5. Applications move to Senior Admin if approved

### For Senior Admins
1. Login with username: `seniorAdmin`, password: `Senior@12345`
2. View applications approved by Junior Admin
3. Review application details and Junior Admin comments
4. Add final comments and approve or reject
5. Approved applications get application numbers

## Status Flow

```
PENDING → JUNIOR_APPROVED → APPROVED
    ↓           ↓
REJECTED    REJECTED
```

## Security Features

- Role-based access control
- Password hashing (implemented in backend)
- Session management
- Input validation
- CORS configuration

## Future Enhancements

- Email notifications
- Document upload functionality
- Payment integration
- Mobile app development
- Advanced reporting and analytics
- Multi-language support
- SMS notifications

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is licensed under the MIT License.

## Support

For support and questions, please contact the development team.













   
